package oos.uebung.uebung5.serialisierung.beiZyklischenVerweisen;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        /*
        Player dat = new Player();
        Room toilette = new Room();
        dat.room = toilette;    // dat ist in toilette
        toilette.player = dat;  // Toilette erkennt dat
        System.out.println(dat);
        System.out.println(dat.room);
        System.out.println(toilette);
        System.out.println(toilette.player);
        try {
            FileOutputStream fOS = new FileOutputStream("file.dat");
            ObjectOutputStream oOS = new ObjectOutputStream(fOS);
            oOS.writeObject(dat);
            oOS.close();
        } catch (IOException e) {
            e.getMessage();
        }

         */


        try{
            Player dat = new Player();
            FileInputStream fIS = new FileInputStream("file.dat");
            ObjectInputStream bIS = new ObjectInputStream(fIS);
            dat = (Player) bIS.readObject();
            Room toilette = dat.room;
            System.out.println(dat.room.player);
            System.out.println(dat);
            System.out.println(dat.room);
            System.out.println(toilette);
            System.out.println(toilette.player);
            bIS.close();
        }catch (IOException e){
            e.getMessage();
        }catch (ClassNotFoundException e){
            e.getMessage();
        }
         //*/
    }
}
