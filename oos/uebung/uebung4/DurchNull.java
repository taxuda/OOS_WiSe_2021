package oos.uebung.uebung4;
//aufgabe 18 Uebung 4
//try thuc hien  -> finally thuc hien
//try ra loi -> catch xu ly -> finally thuc hien
//try ra loi -> catch khong xu ly -> finally thuc hien
public class DurchNull {
    public static void main(String[] args) throws MeineException {
        int a = 10;
        int nenner[] = {1,0,2};
        for (int i = 0; i < 4; i++) {
            try {
                if(i==2) {
                    System.out.println("toi nem ra mot ngoai le!");
                    throw new MeineException("index vuot qua");
                }
                System.out.println(a / nenner[i]);
            } catch (ArithmeticException e) {
                System.out.println("try ra loi -> catch xu ly -> finally thuc hien");
                System.out.println(e);
            }
            finally {
                System.out.println("luon thuc hien");
                System.out.println();
            }
        }
    }
}
