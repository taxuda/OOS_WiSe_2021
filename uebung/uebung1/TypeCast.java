package uebung.uebung1;

public class TypeCast {
    public static void main(String[] args){
        //Ngoai ra automatisch Typecast
        //oder Impliziter Typecast
        //Spezialfall - Strings
        int c = 49;
        String b = "Day la " + c;
        int a = 2502;
        System.out.println("Wert = " + a);
        System.out.println(b);


        double d = 100.03;
        long l = (long)d;
        //explicit Conversion
        //Expliziter Typecast
        int i = (int)l;
        System.out.println("fractional part lost/ phan thap phan bi mat - i =  " + i);

        byte k;
        int m = 257;
        double p = 323.142;
        System.out.println("Conversion of int to byte.");

        //m%256
        k = (byte) m;
        System.out.println("m = " + m + " k = " + k);
        System.out.println("\nConversion of double to byte.");

        //p%256
        k = (byte) p;
        System.out.println("p = " + p + " k= " + k);


    }
}
