package oos.uebung.uebung1;

public class Primfaktorzerlegung {
    public double fak(int n){
        double fak_n = 1;
        for(int i = 1; i < n + 1; i++){
            fak_n = fak_n * i;
        }
        return fak_n;
    }
    public static void main(String[] args){
        Primfaktorzerlegung fakultaet = new Primfaktorzerlegung();
        System.out.println(fakultaet.fak(40));
        int number = 16;
        int primezahl = 2;
        while(true){
            if(number % primezahl != 0){
                primezahl++;
            }
            else if(number % primezahl == 0){
                number = number/primezahl;
                System.out.println(" " + primezahl);
                primezahl = 2;
            }
            if(number == primezahl) {
                System.out.println(" " + primezahl);
                break;
            }
        }

        double[] fibonaccizahl = new double[50];
        fibonaccizahl[0] = 1;
        fibonaccizahl[1] = 1;
        System.out.println(1 + " -> " + fibonaccizahl[0]);
        System.out.println(2 + " -> " + fibonaccizahl[1]);
        for(int i = 2; i < 50; i++){
            fibonaccizahl[i]=fibonaccizahl[i-1] + fibonaccizahl[i-2];
            System.out.println(i+1 + " -> " + fibonaccizahl[i]);

        }
    }
}
