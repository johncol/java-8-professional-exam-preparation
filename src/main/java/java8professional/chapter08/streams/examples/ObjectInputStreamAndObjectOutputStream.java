package java8professional.chapter08.streams.examples;

import java8professional.chapter08.streams.examples.sample.DragonAgeCharacter;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java8professional.chapter08.streams.examples.sample.DragonAgeCharacterType.*;

public class ObjectInputStreamAndObjectOutputStream {

    private static final String FILE_PATH = "src/main/resources/iofiles/dragon-age-characters.data";

    static void serializeCharacters(List<DragonAgeCharacter> characters, File destination) throws IOException {
        try (   OutputStream fos = new FileOutputStream(destination);
                OutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream out = new ObjectOutputStream(bos)) {
            for (DragonAgeCharacter character : characters) {
                out.writeObject(character);
            }
        }
    }

    static List<DragonAgeCharacter> deserializeCharacters(File source) throws IOException {
        List<DragonAgeCharacter> characters = new ArrayList<>();
        try (   InputStream fis = new FileInputStream(source);
                InputStream bis = new BufferedInputStream(fis);
                ObjectInputStream in = new ObjectInputStream(bis)) {
            while (true) {
                Object object = in.readObject();
                if (object instanceof DragonAgeCharacter) {
                    characters.add((DragonAgeCharacter) object);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            System.out.println("All characters read!");
        }
        return characters;
    }

    public static void main(String[] args) throws IOException {
        File file = new File(FILE_PATH);

        List<DragonAgeCharacter> characters = createDragonAgeCharactersList();
        serializeCharacters(characters, file);

        List<DragonAgeCharacter> deserializedCharacters = deserializeCharacters(file);
        deserializedCharacters.forEach(System.out::println);
    }

    static List<DragonAgeCharacter> createDragonAgeCharactersList() {
        DragonAgeCharacter theWarden = new DragonAgeCharacter.Builder()
                .withName("The Warden")
                .withType(WARRIOR)
                .withDescription("The main protagonist of the game. You become a Grey Warden after going " +
                        "through a unique origin story tailored to your race and background. Afterwards, " +
                        "you go to Ostagar in order to join King Cailan in a supposedly final battle against " +
                        "the Darkspawn. You also need to undergo The Joining, a ceremony in which you are " +
                        "initiated into the Grey Wardens.")
                .build();
        DragonAgeCharacter morrigan = new DragonAgeCharacter.Builder()
                .withName("Morrigan")
                .withType(MAGE)
                .withDescription("Daughter of Flemeth, the mysterious Witch of the Wilds, Morrigan is a " +
                        "Lady of Black Magic forced to join the party by her own mother for reasons that are " +
                        "very unclear at first. Shale's nickname for her is 'The Swamp Witch'.")
                .build();
        DragonAgeCharacter leliana = new DragonAgeCharacter.Builder()
                .withName("Leliana")
                .withType(ROGUE)
                .withDescription("Leliana is a former Orlesian bard and a lay sister at the Chantry in " +
                        "Lothering. After receiving a prophetic dream about the Blight, she decides to join " +
                        "the PC on his/her quest. Shale's nickname for her is 'The Sister' and occasionally" +
                        " 'The Bard.'")
                .build();
        return Arrays.asList(theWarden, morrigan, leliana);
    }

}

