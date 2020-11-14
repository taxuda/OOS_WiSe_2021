package oos.uebung.uebung1;

public class Matrizen<i> {
    public static void main(String[] args){
        final int I = 3, J = 2, K = 3;
        int[][] a = new int[I][J];
        int[][] b = new int[J][K];
        //Initialisierung und Ausgabe
        System.out.println("a = ");
        for(int i = 0; i < I; i++){
            for(int j = 0; j < J; j++){
                a[i][j] = 10 * i + j;
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("b = ");
        for(int i = 0; i < J; i++){
            for(int j = 0; j < K; j++){
                b[i][j] = i + 10 * j;
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
        //Multiplikation von a x b
        int[][]c = new int[I][K];
        System.out.println("c = ");
        for(int i = 0; i < I; i++){
            for(int k = 0; k < K; k++){
                c[i][k] = 0;
                for(int j = 0; j < J; j++){
                    c[i][k] += a[i][j]*b[j][k];
                }
                System.out.print(c[i][k] + " ");
            }
            System.out.println();
        }
    }

}
