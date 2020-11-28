package oos.uebung.uebung5.serialisierung.vonMehrenObjektenUndPrimitivenTypen;

import java.io.*;
// Serialisierung thi luon su dung ObjectOutputStream/ObjectInputStream
// Class con cua InputStream va OutputStream


public class Serialisierung {
    public static void main (String[] args){
        /*
        // Hieu sai de bai; De bai yeu cau serialisiert Objekt / Objekt Persistenz
        // Bai lam: Luu het ra file.txt duoi dang text
        // Bai lam: Da su dung Reader/Writer (textuelle Eingabeströme)
        try{
            int wert = 160598;
            String stringObj = new String("hier ist ein string-Objekt");
            Zeit zeit = new Zeit(23, 18);
            FileOutputStream fos = new FileOutputStream("serialisierungViel.txt");
            PrintWriter pw = new PrintWriter(fos);
            pw.println(wert);
            pw.println(stringObj);
            pw.println(zeit);
            pw.close();
        }catch (IOException e){
            e.getMessage();
        }

         */
        try{
            /*
            FileOutputStream fos = new FileOutputStream("serialisierung.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeInt(16051998);
            oos.writeObject("Tran Xuan Dat");
            oos.writeObject(new Zeit(23,42));
            oos.close();

            */
            ///*
            FileInputStream fis = new FileInputStream("serialisierung.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            // Fehler: writeInt() -> readInt()
            //  Truoc do: int wert = (int) ois.readObject(); -> falsch
            int wert = (int) ois.readInt();
            String taxuda = (String) ois.readObject();
            Zeit zeit = (Zeit) ois.readObject();
            System.out.println(wert);
            System.out.println(taxuda);
            System.out.println(zeit);
            //ois.close();

             //*/
        }catch (IOException e){
            e.getMessage();
        }catch(ClassNotFoundException e){
            e.getMessage();
        }
    }
}
