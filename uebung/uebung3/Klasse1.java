package uebung.uebung3;

//wenn pakage-Befehl in Klasse1 gelöscht ist,
// Klasse1 kann Klasse 2 und Klass3 nicht zugreifen.

//und dann wenn package-Befehl in Klasse3.java gelöscht ist
//WICHTIG!!!: und muss die Klassen(1,2,3) aus dem übung3-Ordner verschieben
//Klasse 1 kann Klasse3 wieder zugreifen.

public class Klasse1 extends Klasse2 {
    public static void main(String[] args){
        Klasse2 klasse2 = new Klasse2();
        klasse2.defaultt = 0;
        klasse2.pblic = 0;
        klasse2.protect = 0;
        //klasse2.private kann nicht initilisiert werden.

        //h) Objekt lässt sich erzeugen, weil Klasse friendly und
        //die Datei in gleiche Paket liegt.
        Klasse3 klasse3 = new Klasse3();

        // i)
        klasse3.pblic = 0;
        klasse3.protect = 0;
        klasse3.defaultt = 0;
        //klasse3.private kann nicht initialisiert werden, weil private und nur in
        //Klasse3 verfügbar!

        //Klasse4 klasse4 = new Klasse4();
        //Zugriff aus anderem Paket ist nicht möglich, das Klasse nur friendly ist.
    }
}
