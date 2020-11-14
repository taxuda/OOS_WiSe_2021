package uebung.uebung4;

public class Exceptions {
    public static void main (String[] args) {
        String[] numbers = new String[3];
        numbers[0] = "10";
        numbers[1] = "20";
        numbers[2] = "30";

        for(int base = 10; base >= 2; --base){
            for(int i = 0; i <= 3; i++){
                try {
                    // fehler 1: typ int // int j = Integer.parseInt(numbers[i], base);
                    int j = Integer.parseInt(numbers[i], base);
                    System.out.println(numbers[i] + "base " + base + " = " + j);
                }
                catch (NumberFormatException e2){
                    System.out.println("***NFEx: ");
                }
                catch(IndexOutOfBoundsException e1){
                    System.out.println("***IOOBEx: ");
                }
            }
            System.out.println();
        }
    }
}
