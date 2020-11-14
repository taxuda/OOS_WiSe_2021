package uebung.uebung2;

public class GesamtVolumen {
    public static void main(String[] args){
        Quader quader1 = new Quader(4,5,6);
        Quader quader2 = new Quader(5,6,7);
        Pyramide pyramide = new Pyramide(2,3,4);
        Körper[] arr = new Körper[3];
        arr[0] = quader1;
        arr[1] = quader2;
        arr[2] = pyramide;
        int gesamtVolumen = 0;
        for(int i = 0; i < 3; i++){
            gesamtVolumen += arr[i].volumen();
        }
        System.out.println(gesamtVolumen);
    }
}
