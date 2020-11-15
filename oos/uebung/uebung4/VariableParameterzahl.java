package oos.uebung.uebung4;

public class VariableParameterzahl {
    /**
     * statische Methode, die eine variable Anzahl von Strings als Parameter erwartet
     * und die Konkatenation der Strings liefert.
     * @param eingabe als ein Array der String-parameters.
     * @return eine String, als Konkatenation(Aneinanderreihung) von den String-eingaben
     */
    static String konkatenation(String... eingabe) throws IllegalArgumentException{
        String ausgabe = "";
        if(eingabe.length == 1){
            throw new IllegalArgumentException("bitte geben mehr als ein Argument zur diesen Methode ein!");
        }
        else {
            for (String string : eingabe) {
                ausgabe = ausgabe + " " + string;
            }
            return ausgabe;
        }
    }
    public static void main (String[] args){
        try{
            String hello = konkatenation("dit", "me", "may");
            String hello2 = konkatenation("ditcumay");
            System.out.println(hello);
            System.out.println(hello2);
        }catch (IllegalArgumentException e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
