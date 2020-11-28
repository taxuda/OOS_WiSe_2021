package oos.uebung.uebung5.serialisierung.vonMehrenObjektenUndPrimitivenTypen;

import java.io.Serializable;

public class Zeit implements Serializable {
    int stunde;
    int minute;
    Zeit(int s, int m){
        this.stunde = s;
        this.minute = m;
    }
    public String toString(){
        return stunde + ":" + minute;
    }
}
