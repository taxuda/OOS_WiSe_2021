package uebung.uebung4;

public class AusnahmeBsp {
    int att;
    void nullpointer(){
        AusnahmeBsp ausnahmeBsp = null;
        ausnahmeBsp.att = 1;
    }
    public static void main(String[] args){
        try {
            AusnahmeBsp ab = new AusnahmeBsp();
            ab.nullpointer();
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}
