package oos.vorlesung.oos_05;

public class NegativeKontostandException extends Exception {
    NegativeKontostandException(String ausgabe){
        super(ausgabe);
    }
}
