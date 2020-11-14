package oos.uebung.uebung4;
//Uebung 19
public class UngeradeZahlEx {
    public void ungeradeZahl(int i) throws ArithmeticException{
        if(i%2 == 1){
            throw new ArithmeticException("Tham so la so le!");
        }
    }
    public static void main(String[] args){
        try{
            UngeradeZahlEx sole = new UngeradeZahlEx();
            sole.ungeradeZahl(3);
        }catch(ArithmeticException e){
            System.out.println(e);
        }
    }
}
