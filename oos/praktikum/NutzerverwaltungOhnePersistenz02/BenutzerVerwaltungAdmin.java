package oos.praktikum.NutzerverwaltungOhnePersistenz02;

import java.util.ArrayList;

public class BenutzerVerwaltungAdmin extends Benutzer implements BenutzerVerwaltung {

    /**
     * Datenhaltung: implementiert ArrayList als Datenstruktur um
     * Benutzer-Objekt zu halten
     */
    private static ArrayList<Benutzer> Datenhaltung = new ArrayList<Benutzer>();

   /**
    * Konstruktor um ein BenutzerVerwaltungAdmin-Objekt zu erstellen
    * @see Benutzer wenden hier Konstruktor von Benutzer-Klasse an
    * @param id userID des Adminkonto
    * @param pw passwort des Adminkonto
    */
   BenutzerVerwaltungAdmin(String id, char[] pw){
       super(id,pw);
   }

    /**
     * Eintragen ein Benutzerobjekt in die Datenhaltung.
     * @param benutzer das Benutzerobjekt, das in der Datenhaltung eingetragen wird.
     */
   public void benutzerEintragen(Benutzer benutzer){
       try{
           if(benutzerVorhanden(benutzer)){
               throw new ParameterDuplikat("Parameter ist vorhanden! Bitte eintragen einen neuen Benutzer");
           }
           Datenhaltung.add(benutzer);
       }
       catch(ParameterDuplikat e){
           e.printStackTrace();
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
   protected void benutzerLoeschen(Benutzer benutzer){
       try{
           if(Datenhaltung.isEmpty()){
               throw new NullPointerException("Datenhaltung ist leer!");
           }
           else if(!benutzerVorhanden(benutzer)){
               throw new NullPointerException("Benutzer ist nicht vorhanden! Kann nicht loeschen!");
           }
           Datenhaltung.remove(benutzer);
       }
       catch(NullPointerException e){
           e.printStackTrace();
       }
   }

    /**
     * Überprüfen ob ein Objekt schon in der Datenhaltung vorhanden ist.
     * @param benutzer Objekt von Benutzerklasse, das überprüft wird, ob es vorhanden ist.
     * @return true, falls das Parameterobjekt in der Datenhaltung vorhanden ist, sonst false
     */
   public boolean benutzerVorhanden(Benutzer benutzer){
        boolean vorhanden = false;
        for(int i = 0; i < Datenhaltung.size(); i++){
            /*
            //userID must eindeutig sein!
            if(benutzer.userID == Datenhaltung.get(i).userID){
                vorhanden = true;
                break;
            }
             */
            if(benutzer.equals(Datenhaltung.get(i))){
                vorhanden = true;
                break;
            }
        }
        return vorhanden;
   }
}
