package oos.uebung.uebung2;

public class Quader implements Körper {
    int länge;
    int breite;
    int höhe;
    Quader(){}
    Quader(int l, int b, int h){
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
        Quader quader = new Quader(5,6,7);
        System.out.println(quader.volumen());
    }
}
