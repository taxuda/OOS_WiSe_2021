package oos.uebung.uebung4;

import com.sun.nio.file.ExtendedWatchEventModifier;

public class Main implements Ueb4interface_methode {

    public void exWerfenUndWeiterleiten() throws MeineException{
        throw new MeineException("day la loi");
    }

    public static void main(String[] args){
        Main object = new Main();
        try{
         object.exWerfenUndWeiterleiten();
        }catch(MeineException e){
            System.out.println(e); //khong can println(e.toString())
            System.out.println("thang coder rat la ngu!");
        }finally {
            System.out.println("Cuoi cung cung thuc hien");
        }
        System.out.println("kiem tra: khi catch thuc thi -> chuong trinh dung lai o mot trang thai");
    }
}
