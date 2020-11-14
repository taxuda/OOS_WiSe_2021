package oos.uebung.uebung4;

import java.io.IOException;

public class MeineException extends IOException {
    MeineException(String ausgabe){
        super(ausgabe);
    }
}
