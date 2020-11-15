package oos.praktikum.NutzerverwaltungOhnePersistenz02;

public class Test {
    public static void main(String[] args){
        Benutzer benutzer1 = new Benutzer("benutzer1", new char[]{'a','b','c','d'});
        Benutzer benutzer1_1 = new Benutzer("benutzer1", new char[]{'a','b','c','d'});
        Benutzer benutzer2 = new Benutzer("benutzer2", new char[]{'a','b','c','d'});
        BenutzerVerwaltungAdmin admin = new BenutzerVerwaltungAdmin("admin", new char[]{'a','b','c','d'});


        //Benutzer - Test
        System.out.println("Benutzer - Test");
            //toString - Test
        System.out.println("toTring - Test");
        System.out.println(benutzer1);
        System.out.println(admin);
        System.out.println();

            //equals - Test
        System.out.println("equals - Test");
        System.out.println("?benutzer1 equals benutzer1_1 : " + benutzer1.equals(benutzer1_1));
        System.out.println("?benutzer1 equals benutzer2 : " + benutzer1.equals(benutzer2));
        System.out.println("?benutzer1 equals admin : " + benutzer1.equals(admin));
        System.out.println();



        //Admin - Test
        System.out.println("Admin - Test");
            //benutzerEintragen - Test
        System.out.println("benutzerEintragen - Test");
        admin.benutzerEintragen(benutzer1);
        //System.out.println("Datenhaltung besteht aus:" + admin.Datenhaltung.get(0));
        System.out.println("?benutzer1 vorhanden : " + admin.benutzerVorhanden(benutzer1));
        admin.benutzerEintragen(benutzer1_1);
        System.out.println();

            //benutzerLoeschen - Test
        System.out.println("benutzerLoschen - Test");
                //Datenhaltung ist leer! - Test
        admin.benutzerLoeschen(benutzer1);
        admin.benutzerLoeschen(benutzer1);
                //Benutzer nicht vorhanden! - Test
        admin.benutzerEintragen(benutzer1);
        admin.benutzerLoeschen(benutzer2);

    }
}
