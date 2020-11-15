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
    * Konstruktor um ein BenutzerVerwaltungAdmin-Objekt zu erstellen
    * @see Benutzer wenden hier Konstruktor von Benutzer-Klasse an
    * @param id userID des Adminkonto
    * @param pw passwort des Adminkonto
    */
    /*
   BenutzerVerwaltungAdmin(String id, char[] pw){
       super(id,pw);
   }
    */

    /**
     * Eintragen ein Benutzerobjekt in die Datenhaltung.
     * @param benutzer das Benutzerobjekt, das in der Datenhaltung eingetragen wird.
     */
   public void benutzerEintragen(Benutzer benutzer) throws BenutzerVerwaltungException{
       try{
           if(benutzerVorhanden(benutzer)){
               throw new BenutzerVerwaltungException("Benutzer ist schon vorhanden!");
           }
           else{
               Datenhaltung.add(benutzer);
           }
       }catch (NumberFormatException e){
           throw e;
       }
   }

    /**
     * Entfernen ein Objekt aus der Datenhaltung.
     * Fallunterscheidung:
     * Datenhaltung is empty,
     * Parameterobjekt ist nicht in der Datenhaltung vorhanden,
     * Parameterobjekt ist vorhanden, wird entfernt.
     * @param benutzer das Benutzerobjekt, das aus der Datenhaltung entfernt wird.
     *
     */
   public void benutzerLoeschen(Benutzer benutzer) throws BenutzerVerwaltungException{
       try{
           if(Datenhaltung.isEmpty()){
               throw new NullPointerException("Es gibt keinen Benutzer zum Löschen!");
           }
           else{
               if(!benutzerVorhanden(benutzer)){
                   throw new BenutzerVerwaltungException("Benutzer ist nicht vorhanden! Kann nicht loeschen!");
               }else{
                   Datenhaltung.remove(benutzer);
               }
           }

       }
       catch(NumberFormatException e){
           throw e;
       }
   }

    /**
     * Überprüfen ob ein Objekt schon in der Datenhaltung vorhanden ist.
     * @param benutzer Parameterobjekt der Klasse Benutzer, das überprüft wird, ob vorhanden ist.
     * @return true, falls dieses Parameterobjekt in der Datenhaltung vorhanden ist,
     * sonst false
     */
   public boolean benutzerVorhanden(Benutzer benutzer) throws NumberFormatException{
        boolean vorhanden = false;
        //Durchsuchen alle Elemente der Datenhaltung mit for Schleife
        try {
            for (int i = 0; i < Datenhaltung.size(); i++) {
                //userID must eindeutig sein!

                //vergleichen zuerst die userID
                if (benutzer.hashCode() == Datenhaltung.get(i).hashCode()) {

                    if (benutzer.equals(Datenhaltung.get(i))) {
                        vorhanden = true;
                        break;
                    }
                }

            }
        }catch (NumberFormatException e){
            throw new NumberFormatException("userId von Parameterobjekt darf nur Zahlen enthalten!");
        }
        return vorhanden;
   }
}
