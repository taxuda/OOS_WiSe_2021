package oos.uebung.uebung5.deserialisierung;

import java.io.Serializable;

public class C extends B implements Serializable {
    public int c = 3;
    C(){
        System.out.println("Objekt von Klasse C");
    }
}
