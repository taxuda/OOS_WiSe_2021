package oos.praktikum.NutzerverwaltungOhnePersistenz02;


public class Benutzer {
    //userID must contain nur numbers
    String userID;
    char[] passwort;

    Benutzer(){}

    Benutzer(String id, char[] pw){
        userID = id;
        passwort = pw.clone();
    }

    /**
     * Diese Methode ist als Überlagerung der gleichen Methode
     * der Klasse Object zu implementieren
     * @param obj Objekt der Klasse Object
     * @return true wenn this und obj identisch sind.
     */
   @Override
    public boolean equals(Object obj){
        //Shallow comparison
        // Überprüfen, ob sich beide Objektreferenzen auf dasselbe Objekt verweisen.
        if(this == obj){
            return true;
        }

        //Deep comparison
        // Es prüft, ob das Argument vom Typ Benutzer ist,
        // indem es die Klassen des übergebenen Arguments und dieses Objekts vergleicht.
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        // Typumwandlung des Arguments.
        Benutzer benutzer = (Benutzer) obj;

        // Vergleich den Zustand des Arguments mit dem Zustand von 'this' Objekt.
        // Nen khai bao ro 2 String passwort!
        String thisPasswort = "";
        thisPasswort = thisPasswort.copyValueOf(this.passwort);
        String benutzerPasswort = "";
        benutzerPasswort = benutzerPasswort.copyValueOf(benutzer.passwort);

        return (benutzer.userID.equals(this.userID) && benutzerPasswort.equals(thisPasswort));
   }

    /**
     * wenn der Methode equals(Object o) der Klasse Object überlagert wird
     * soll diese Methode hashCode auch überlagert werden.
     * @return userID als ein Integer
     */
   @Override
    public int hashCode(){
        //umwandeln String userID zu Integer userID
        int ID = Integer.parseInt(this.userID);
        return ID;
   }

    /**
     * this method of class Benutzer override the Object toString() method
     * replace classname@HashCode_in_Hexadeciaml_form of the Object toString() method
     * by using one string as output
     * @return a String in form "UserID: userID; Passwort: passwort"
     */
    @Override
    public String toString(){
        return ("UserID: " + userID + " ;Passwort: " + String.copyValueOf(this.passwort));
    }
}
