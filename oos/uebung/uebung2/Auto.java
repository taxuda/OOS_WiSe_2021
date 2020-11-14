package oos.uebung.uebung2;

/**Aufgabe 7_ Konstruktoren
 * @author dattran
 * */

public class Auto {
    String typ;
    String farbe;
    int baujahr;
    private int kmStand;
    int inspektionsIntervall;
    static int anzErzeugteAutos = 0;
    static int gesamtLeistung = 0;

    Auto(String Typ, String Farbe, int Baujahr, int KmStand, int InspektionsIntervall){
        typ = Typ;
        farbe = Farbe;
        baujahr = Baujahr;
        kmStand = KmStand;
        inspektionsIntervall = InspektionsIntervall;
        anzErzeugteAutos++;
        gesamtLeistung += kmStand;
    }

    Auto(String Typ){
        typ = Typ;
        anzErzeugteAutos++;
    }

    /*aachen.fh.oos.uebung1.Auto(String Farbe){
        farbe = Farbe;
    }

    */

    public void setKmStand(int km){
        gesamtLeistung -= kmStand;
        kmStand = km;
        gesamtLeistung += kmStand;
    }

    static float kmDurchschnitt(){
        return ((float)gesamtLeistung/anzErzeugteAutos);
    }

    /*
    public static void main(String[] args){
        aachen.fh.oos.uebung1.Auto auto1 = new aachen.fh.oos.uebung1.Auto("BMW","orange",1998, 10,30);
        aachen.fh.oos.uebung1.Auto auto2 = new aachen.fh.oos.uebung1.Auto("Merz","orange",1998, 20,30);
        aachen.fh.oos.uebung1.Auto auto3 = new aachen.fh.oos.uebung1.Auto("Fiat","orange",1998, 30,30);
        aachen.fh.oos.uebung1.Auto auto4 = new aachen.fh.oos.uebung1.Auto("Vinfast","orange",1998, 40,30);
        aachen.fh.oos.uebung1.Auto auto5= new aachen.fh.oos.uebung1.Auto("Cadilac","orange",1998, 50,30);
        auto1.setKmStand(60);
        auto2.setKmStand(20);


        auto3.setKmStand(30);
        auto4.setKmStand(40);
        auto5.setKmStand(50);

        System.out.println(auto1.kmDurchschnitt());
        System.out.println(auto2.kmDurchschnitt());
        System.out.println(auto3.kmDurchschnitt());
        System.out.println(auto4.kmDurchschnitt());
        System.out.println(auto5.kmDurchschnitt());
    }
    */
}
