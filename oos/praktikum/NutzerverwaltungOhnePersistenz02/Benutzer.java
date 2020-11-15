package oos.praktikum.NutzerverwaltungOhnePersistenz02;


public class Benutzer {
    String userID;
    char[] passwort;

    Benutzer(){}

    Benutzer(String id, char[] pw){
        userID = id;
        passwort = pw.clone();
    }

    //ueberlagern: mit Objekt vergleichen
    //und ueberladen: hart
    public boolean equals(Benutzer benutzer){
        String password1 = "";
        password1 = password1.copyValueOf(passwort);
        String password2 = "";
        password2 = password2.copyValueOf(benutzer.passwort);
        return (userID.equals(benutzer.userID) && password1.equals(password2));
    }
    /*
    protected boolean equals(Benutzer benutzer){
        //return this.equals(benutzer)
        String password1 = "";
        password1 = password1.copyValueOf(passwort);
        String password2 = "";
        password2 = password2.copyValueOf(benutzer.passwort);
        return (userID.equals(benutzer.userID) && password1.equals(password2));
    }

     */

    public String toString(){
        return ("UserID: " + userID + " ;Passwort: " + String.copyValueOf(this.passwort));
    }
}
