package oos.uebung.uebung5.deserialisierung;

import java.io.*;

public class D extends C implements Serializable {
    public int d = 4;
    D(){
        System.out.println("Objekt von Klasse D");
    }

    @Override
    public String toString() {
        return "D{" +
                "d=" + this.d + "; " +
                "c=" + this.c + "; " +
                "b=" + this.b + "; " +
                "a=" + this.a +
                '}';
    }

    public static void main(String[] args){
        D objekt = new D();
        objekt.a = 5;
        objekt.b = 6;
        objekt.c = 7;
        objekt.d = 8;
        System.out.println(objekt);
        try {
            /*
            FileOutputStream fos = new FileOutputStream("a24.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(objekt);
            oos.close();
             */
            FileInputStream fis = new FileInputStream("a24.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            D dNeu = (D) ois.readObject();
            System.out.println(dNeu);
            ois.close();
        }catch (IOException e){
            e.getMessage();
        }catch (ClassNotFoundException e){
            e.getMessage();
        }
    }
}
