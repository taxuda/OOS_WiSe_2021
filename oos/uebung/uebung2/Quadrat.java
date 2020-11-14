package oos.uebung.uebung2;

public class Quadrat extends Point {
    Point EckeUntenLinks;
    double Seitelänge;

    Quadrat(){}
    Quadrat(Point x, double l){
        EckeUntenLinks = x;
        Seitelänge = l;
    }
    Quadrat(Quadrat anders){
        EckeUntenLinks = anders.EckeUntenLinks;
        Seitelänge = anders.Seitelänge;
    }

    /*
    1. get- und setLocation erben, damit man die Position der Quadrats setzen
    und erhalten kann
    2. move auch, damit man es verschieben kann
    3. überladen wird equals() und toString() wird überlagert,
    da jetzt ja auch noch das dritte Attribut"Seitelänge" mit einbezogen werden muss.
    4. Seitelänge-Attribut muss verarbeitet (get- und setSeitelänge) werden.
     */

    void setSeitelänge(double l){
        Seitelänge = l;
    }

    double getSeitelänge(){
        return Seitelänge;
    }

    /**
     * überprüft, ob die Attributwerte des aktuellen Objekts mit denen des Parameterobjekts
     * übereinstimmen.
     * @param anders ein aachen.fh.oos.uebung1.Quadrat-Objekt zu überprüfen
     * @return true wenn die Attributwerte des aktuellen Objekts und Parameterobjekts identisch sind.
     */
    boolean equals(Quadrat anders){
        return (EckeUntenLinks.equals(anders.EckeUntenLinks)&& (Seitelänge == anders.Seitelänge));
    }

    /**
     * stellt das Objekt als String dar in der folgenden Form: (x,y) l
     * @return Stringausgabe in der folgenden Form: Ecke unten links: (x,y) Seitelänge: l
     */
    public String toString(){
        return ("Enke unter links: " + EckeUntenLinks.toString() + " Seitelänge: " + Seitelänge);
    }

    public static void main(String[] args){
        Quadrat quadrat = new Quadrat(new Point(1,2),5);
        System.out.println(quadrat.toString());
    }
}

