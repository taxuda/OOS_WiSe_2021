package oos.uebung.uebung2;

abstract class Mitarbeiter {
    //gemeinsame Attribute
    int persNr;
    String Name;
    int alt;

    //gemainsame Methode
    public String toString(){
        return ("personal Number: " + persNr + " Name: " + Name + " Alt: " + alt);
    }
    //abstrakte Methode
    abstract double monatsBrutto();
}
