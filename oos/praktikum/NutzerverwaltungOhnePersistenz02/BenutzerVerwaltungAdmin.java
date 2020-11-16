package oos.praktikum.NutzerverwaltungOhnePersistenz02;

import java.util.ArrayList;

public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung {

    /**
     * Datenhaltung: implementiert ArrayList als Datenstruktur
     * um Benutzer-Objekt zu halten
     * ? nen de la static hay la khong
     */
    private ArrayList<Benutzer> Datenhaltung = new ArrayList<>();

    /**
     * Überprüfen, ob die userId von benutzer gültig ist.
     * @param benutzer ,benutzer.userID überprüft wird.
     * @return true, falls userID das richtige Format hat;
     * sonst falsch.
     */
    public boolean invalidUserId(Benutzer benutzer){
        return ((benutzer.userID == null) ||
                (benutzer.userID.length() == 0) ||
                !benutzer.userID.matches("[0-9]+"));
    }

    /**
     *Überprüfen, ob das Passwort von benutzer gültig ist.
     * @param benutzer, benutzer.passwort überprüft wird.
     * @return true, falls passwort nicht leer ist und mehr als 5 Zeichen enthält;
     * sonst, falsch
     */
    public boolean invalidUserPassword(Benutzer benutzer){
        return ((benutzer.passwort == null) || (benutzer.passwort.length <= 5));
    }

    /**
     * Diese Methode trägt den gültigen Benutzereingabe in Datenhaltung ein.
     * @param benutzer wird in eine Datenhaltung eingetragen.
     * @throws Benutzer.InvalidUserId
     * @throws Benutzer.InvalidPasswort
     * @throws BenutzereingabeDuplikatException
     */
   public void benutzerEintragen(Benutzer benutzer)
           throws Benutzer.InvalidUserId,
           Benutzer.InvalidPasswort,
           BenutzereingabeDuplikatException{

       if(invalidUserId(benutzer))
           throw new Benutzer.InvalidUserId("UserId darf nicht leer sein und " +
                   "muss nur Zahlen enthalten!");

       if(invalidUserPassword(benutzer))
           throw new Benutzer.InvalidPasswort("Passwort darf nicht leer sein und " +
                   "muss mehr als 5 Zeichen enthalten!");

       if(benutzerVorhanden(benutzer)){
           throw new BenutzereingabeDuplikatException("Benutzer ist schon vorhanden!");
       }

       Datenhaltung.add(benutzer);
   }

    /**
     * Diese Methode löscht den gültigen Benutzer aus der Datenhaltung
     * @param benutzer, wenn gültig ist, wird gelöscht.
     * @throws EmptyDatenhaltungException
     * @throws BenutzerNichtVorhandenException
     * @throws Benutzer.InvalidUserId
     */
   public void benutzerLoeschen(Benutzer benutzer)
           throws EmptyDatenhaltungException,
           BenutzerNichtVorhandenException ,
           Benutzer.InvalidUserId {
       if(invalidUserId(benutzer))
           throw new Benutzer.InvalidUserId("Kann nicht einen ungültigen Benutzer löschen!");

       if(Datenhaltung.isEmpty())
           throw new EmptyDatenhaltungException("Es gibt keinen Benutzer zum Löschen!");

       if(!benutzerVorhanden(benutzer))
           throw new BenutzerNichtVorhandenException("Der eingegebenen Benutzer ist nicht vorhanden zum Löschen!");

       Datenhaltung.remove(benutzer);
   }

    /**
     * Diese Methode überprüft,
     * ob die gültige Benutzereingabe in der Datenhaltung vorhanden ist.
     * @param benutzer suchen in der Datenhaltung nach der benutzer.userID.
     * @return falls das Parameterobjekt in der Datenhaltung vorhanden ist;
     * sonst falsch.
     * @throws Benutzer.InvalidUserId ungültig Parameter
     */
   public boolean benutzerVorhanden(Benutzer benutzer) throws Benutzer.InvalidUserId {
        boolean vorhanden = false;

        if(invalidUserId(benutzer))
            throw new Benutzer.InvalidUserId("UserId darf nicht leer sein und " +
                    "muss nur Zahlen enthalten!");

        //Durchsuchen alle Elemente der Datenhaltung mit for Schleife
        if(!Datenhaltung.isEmpty()){
            for (int i = 0; i < Datenhaltung.size(); i++) {
                //userID must eindeutig sein!
                if (benutzer.hashCode() == Datenhaltung.get(i).hashCode()) {
                    vorhanden = true;
                    break;
                }
            }
        }
        return vorhanden;
   }

   //selbst definierte Fehlerklasse
   public static class EmptyDatenhaltungException extends Exception{
       EmptyDatenhaltungException(){}
       EmptyDatenhaltungException(String ausgabe){
           super(ausgabe);
       }
   }
    public static class BenutzereingabeDuplikatException extends Exception{
        BenutzereingabeDuplikatException(){}
        BenutzereingabeDuplikatException(String ausgabe){
            super(ausgabe);
        }
    }
    public static class BenutzerNichtVorhandenException extends Exception{
        BenutzerNichtVorhandenException(){}
        BenutzerNichtVorhandenException(String ausgabe){
            super(ausgabe);
        }
    }
}
