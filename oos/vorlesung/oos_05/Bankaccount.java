package oos.vorlesung.oos_05;
import java.util.concurrent.ThreadLocalRandom;
public class Bankaccount{
    private float balance;
    private String name;
    private final long bankAccId;

    public Bankaccount(String name){
        this.name = name;
        this.bankAccId = ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE);
    }
    public void deposit (float amount){
        balance += amount;
    }
    public void withdraw (float amount) throws NegativeKontostandException {
        if(amount <= this.balance){
            balance -= amount;
        }else{
            throw new NegativeKontostandException("Nicht genug Geld!");
        }
    }
    public  float getBalance(){
        return  balance;
    }
    public long getBankAccId(){
        return bankAccId;
    }

    /**
     * Die Methode transferiert Geld von einem auf ein anderes Konto
     * @param anders das andere Konto
     */
    public void tranfer(float amount, Bankaccount anders) throws NegativeKontostandException{
        this.withdraw(amount);
        anders.deposit(amount);
    }

}
