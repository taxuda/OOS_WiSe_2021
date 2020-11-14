package uebung.uebung2;

/**
 * Diese Klasse beschreibt einen (zwei-dimensionalen) Punkt und bietet Methoden zur Erzeugung eines
 * Punktes und Veränderung der Koordinaten an.
 */
public class Point {

    /**
     * x-Koordinate des Punktes.
     */
    int x;

    /**
     * y-Koordinate des Punktes.
     */
    int y;

    /**
     * Default-Konstruktor.
     */
    Point() {
    }

    /**
     * Erzeugung und Setzen der Attributwerte auf die Attributwerte des Parameterobjekts.
     */
    Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    /**
     * Erzeugung und Setzen der Attributwerte auf die Parameterwerte.
     */
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Erzeugen eines neuen Punktes mit den gleichen Attributwerten wie des aktuellen Objekts:
     * Unterschied zu Konstruktor ist anderer Aufrufmechanismus, analog zu clone().
     */
    Point getLocation() {
        return (new Point(this));
    }

    /**
     * Setzen der Attributwerte auf die Attributwerte des Parameterobjekts.
     *
     * @param p liefert den Referenzpunkt.
     */
    void setLocation(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    /**
     * Setzen der Attributwerte auf die Parameterwerte.
     */
    void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Verschiebung des Punktes um die Parameterwerte.
     *
     * @param dx: Verschiebungswert in x-Richtung.
     * @param dy: Verschiebungswert in y-Richtung.
     */
    void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    /**
     * Standardmethode equals.
     */
    public boolean equals(Point p) {
        return ((this.x == p.x) && (this.y == p.y));
    }

    /**
     * Standardmethode liefert folgende Ausgabe (x,y).
     */
    public String toString() {
        return ("(" + this.x + "," + this.y + ")");
    }
}

