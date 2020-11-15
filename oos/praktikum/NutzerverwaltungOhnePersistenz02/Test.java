package oos.praktikum.NutzerverwaltungOhnePersistenz02;

public class Test {
    public static void main(String[] args){
        Benutzer benutzer0 = null;
        Benutzer benutzer1 = new Benutzer("benutzer1", new char[]{'a','b','c','d'});
        Benutzer benutzer1_1 = new Benutzer("benutzer1", new char[]{'a','b','c','d'});
        Benutzer benutzer2 = new Benutzer("benutzer2", new char[]{'a','b','c','d'});
        BenutzerVerwaltungAdmin admin = new BenutzerVerwaltungAdmin();


        //Benutzer - Test
        System.out.println("Benutzer - Test");
            //toString - Test
        System.out.println("toTring - Test");
        System.out.println(benutzer0);
        System.out.println(benutzer1);
        System.out.println(benutzer1_1);
        System.out.println(benutzer2);
        System.out.println(admin);
        System.out.println();

            //equals - Test
        System.out.println("equals - Test");
        if(benutzer1.equals(benutzer1_1))
            System.out.println("?benutzer1 equals benutzer1_1 : " + "true");
        System.out.println("?benutzer1 equals benutzer2 : " + benutzer1.equals(benutzer2));
        System.out.println("?benutzer1 equals admin : " + benutzer1.equals(admin));
        System.out.println();




        //benutzerEintragen - Test
        System.out.println("benutzerEintragen - Test");
        /*
        //test falsche Format von userID eintragen.
        try {
            admin.benutzerEintragen(benutzer1);
        }catch (BenutzerVerwaltungException e){
            e.printStackTrace();
        }
         */


        Benutzer user1 = new Benutzer("001", new char[]{'a','b','c','d'});
        Benutzer user2 = new Benutzer("002", new char[]{'a','b','c','d'});
        Benutzer user1_1 = new Benutzer("001", new char[]{'a','b','c','d'});
        try{
            admin.benutzerEintragen(user1);
            admin.benutzerEintragen(user2);
            //test duplikat von userID
            //admin.benutzerEintragen(user1_1);
        }catch(BenutzerVerwaltungException e){
            e.printStackTrace();
        }

        //benutzerLöschen-Test
        try {
            admin.benutzerLoeschen(user1);
            //admin.benutzerLoeschen(user1_1);
            admin.benutzerLoeschen(benutzer1);
            admin.benutzerLoeschen(user2);
            //admin.benutzerLoeschen(user2);
        }catch (BenutzerVerwaltungException e){
            e.printStackTrace();
        }catch (NullPointerException e1){
            e1.printStackTrace();
        }catch (NumberFormatException e2){
            e2.printStackTrace();
        }
    }
}
