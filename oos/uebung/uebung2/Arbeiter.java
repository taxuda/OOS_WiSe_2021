package oos.uebung.uebung2;

public class Arbeiter extends Mitarbeiter {
    double studenLohn;
    double anzahlStuden;
    double ueberStudenZuschlag;
    double anzahlUeberStuden;
    double schichtZulage;

    Arbeiter(){}
    Arbeiter(double sL, double aS, double uSZ, double aUS, double sZ){
        studenLohn = sL;
        anzahlStuden = aS;
        ueberStudenZuschlag = uSZ;
        anzahlUeberStuden = aUS;
        schichtZulage = sZ;
    }
    public double monatsBrutto(){
        return (studenLohn * anzahlStuden
                + ueberStudenZuschlag * anzahlUeberStuden
                + schichtZulage
        );
    }
    public boolean equals(Arbeiter arbeiter){
        return( super.equals(arbeiter)
                && (studenLohn == arbeiter.studenLohn)
                && (anzahlStuden == arbeiter.anzahlStuden)
                && (ueberStudenZuschlag == arbeiter.ueberStudenZuschlag)
                && (anzahlUeberStuden == arbeiter.anzahlUeberStuden)
                && (schichtZulage == arbeiter.schichtZulage)
        );
    }
    public String toString(){
        return (super.toString() +
                " studenLohn: " + studenLohn +
                " anzahlStuden: " + anzahlStuden +
                " ueberStudenZuschlag: " + ueberStudenZuschlag +
                " anzahlUeberStuden: " + anzahlUeberStuden +
                " dschichtZulage: " + schichtZulage);
    }
    public static void main (String[] args){
        Arbeiter arbeiter = new Arbeiter(10,10,10,10,10);
        arbeiter.alt = 23;
        arbeiter.Name = "TranXuanDat";
        arbeiter.persNr = 3255934;
        System.out.println(arbeiter.toString());
    }
}
