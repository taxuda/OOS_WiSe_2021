package uebung.uebung2;

public class Pyramide implements Körper {
    int länge;
    int breite;
    int höhe;

    Pyramide(){}
    Pyramide(int l, int b, int h){
        länge = l;
        breite = b;
        höhe = h;
    }
    public int länge(){
        return länge;
    }
    public int breite(){
        return breite;
    }

    public int höhe() {
        return höhe;
    }

    public int volumen(){
        return länge*breite*höhe;
    }
    public static void main(String[] args){
        Pyramide pyramide = new Pyramide(5,6,7);
        System.out.println(pyramide.volumen());
    }
}
