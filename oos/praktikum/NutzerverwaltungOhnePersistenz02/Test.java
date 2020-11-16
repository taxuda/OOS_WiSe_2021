package oos.praktikum.NutzerverwaltungOhnePersistenz02;

public class Test {
    public static void main(String[] args){
        //Benutzer - Test
        System.out.println("Benutzer - Test");
        System.out.println();

        Benutzer benutzer0 = null;
        Benutzer benutzer1 = new Benutzer("benutzer1", new char[]{'a','b','c','d'});
        Benutzer benutzer1_1 = new Benutzer("benutzer1", new char[]{'a','b','c','d'});
        Benutzer benutzer2 = new Benutzer("benutzer2", new char[]{'a','b','c','d'});
        BenutzerVerwaltungAdmin admin = new BenutzerVerwaltungAdmin();

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
        try {
            admin.benutzerEintragen(new Benutzer("001", "password".toCharArray()));
            admin.benutzerEintragen(new Benutzer("002", "p4ssword".toCharArray()));
            admin.benutzerEintragen(new Benutzer("003", "p455word".toCharArray()));
            admin.benutzerEintragen(new Benutzer("004", "p455vvord".toCharArray()));
            admin.benutzerEintragen(new Benutzer("005", "p455vv0rd".toCharArray()));

            System.out.println("add a userID twice to trigger Duplikat exception: ");
            admin.benutzerEintragen(new Benutzer("004", "p455vvodrd".toCharArray()));
        } catch (BenutzerVerwaltungAdmin.BenutzereingabeDuplikatException e) {
            e.printStackTrace();
        } catch (Benutzer.InvalidUserId e1) {
            e1.printStackTrace();
        } catch (Benutzer.InvalidPasswort e2) {
            e2.printStackTrace();
        }

        System.out.println("trigger the invalid userId exception: ");
        try {
            //admin.benutzerEintragen(null);
            //admin.benutzerEintragen(new Benutzer("", "password".toCharArray()));
            admin.benutzerEintragen(new Benutzer("haha", "password".toCharArray()));
        } catch (BenutzerVerwaltungAdmin.BenutzereingabeDuplikatException e) {
            e.printStackTrace();
        } catch (Benutzer.InvalidUserId e1) {
            e1.printStackTrace();
        } catch (Benutzer.InvalidPasswort e2) {
            e2.printStackTrace();
        }

        System.out.println("trigger short password exception:");
        try {
            admin.benutzerEintragen(new Benutzer("006", "1234".toCharArray()));
        }catch (BenutzerVerwaltungAdmin.BenutzereingabeDuplikatException e) {
            e.printStackTrace();
        } catch (Benutzer.InvalidUserId e1) {
            e1.printStackTrace();
        } catch (Benutzer.InvalidPasswort e2) {
            e2.printStackTrace();
        }

        //benutzerVorhanden-Test
        System.out.println();
        System.out.println("benutzerVorhanden - Test");
        try{
            Benutzer user005 = new Benutzer("005", "p455vv0rd".toCharArray());
            Benutzer user006 = new Benutzer("006", "p455vv0rd".toCharArray());

            if(admin.benutzerVorhanden(user005))
                System.out.println("user005 mit userID 005 ist vorhanden.");

            if(!admin.benutzerVorhanden(user006))
                System.out.println("user006 mit userID 006 ist NICHT vorhanden.");
        }catch (Benutzer.InvalidUserId e){
            e.printStackTrace();
        }

        try{
            System.out.println("trigger invalid user input");
            Benutzer userHAHA = new Benutzer("haha", "p455vv0rd".toCharArray());
            admin.benutzerVorhanden(userHAHA);
        }catch (Benutzer.InvalidUserId e){
            e.printStackTrace();
        }



        //benutzerLöschen-Test
        System.out.println();
        System.out.println("benutzerLöschen - Test");
        try {
            System.out.println("trigger delete a invalid userID: ");
            admin.benutzerLoeschen(new Benutzer("001", "password".toCharArray()));
            admin.benutzerLoeschen(new Benutzer("002", "p4ssword".toCharArray()));
            admin.benutzerLoeschen(new Benutzer("003", "p455word".toCharArray()));
            admin.benutzerLoeschen(new Benutzer("004", "p455vvord".toCharArray()));
            //delete an invalid userID
            admin.benutzerLoeschen(new Benutzer("haha", "password".toCharArray()));
            admin.benutzerLoeschen(new Benutzer("005", "p455vv0rd".toCharArray()));
        }catch (Benutzer.InvalidUserId e){
            e.printStackTrace();
        }catch (BenutzerVerwaltungAdmin.EmptyDatenhaltungException e1){
            e1.printStackTrace();
        }catch (BenutzerVerwaltungAdmin.BenutzerNichtVorhandenException e2){
            e2.printStackTrace();
        }

        try {
            System.out.println("trigger delete of nonexistent users: ");
            admin.benutzerLoeschen(new Benutzer("006", "p455vv0rd".toCharArray()));
        }catch (Benutzer.InvalidUserId e){
            e.printStackTrace();
        }catch (BenutzerVerwaltungAdmin.EmptyDatenhaltungException e1){
            e1.printStackTrace();
        }catch (BenutzerVerwaltungAdmin.BenutzerNichtVorhandenException e2){
            e2.printStackTrace();
        }

        try {
            System.out.println("trigger delete when data container is empty: ");
            admin.benutzerLoeschen(new Benutzer("005", "p455vv0rd".toCharArray()));
            admin.benutzerLoeschen(new Benutzer("005", "p455vv0rd".toCharArray()));
        }catch (Benutzer.InvalidUserId e){
            e.printStackTrace();
        }catch (BenutzerVerwaltungAdmin.EmptyDatenhaltungException e1){
            e1.printStackTrace();
        }catch (BenutzerVerwaltungAdmin.BenutzerNichtVorhandenException e2){
            e2.printStackTrace();
        }
    }
}
