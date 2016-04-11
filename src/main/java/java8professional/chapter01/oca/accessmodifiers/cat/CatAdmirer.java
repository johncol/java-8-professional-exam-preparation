package java8professional.chapter01.oca.accessmodifiers.cat;

public class CatAdmirer {

    {
        BigCat bigCat = new BigCat();
        //System.out.println(bigCat.id);    // private
        System.out.println(bigCat.hasPaws); // package
        System.out.println(bigCat.hasFur);  // protected
        System.out.println(bigCat.name);    // public
    }

}
