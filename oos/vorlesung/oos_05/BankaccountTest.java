package oos.vorlesung.oos_05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class BankaccountTest {
    // Vorlesung OOS_05 Hand-On
    Bankaccount mybankAcc = new Bankaccount("Tran Xuan Dat");
    @Test
    public void testBalanceZero(){
        assertEquals(0,mybankAcc.getBalance());
        assertTrue(mybankAcc.getBankAccId()>0);
    }
    @BeforeEach
    public void setUp(){
        mybankAcc = new Bankaccount("Tran Xuan Dat");
    }
    @RepeatedTest(10)
    public void positivIDtest(){
        assertTrue(mybankAcc.getBankAccId()>0);
    }
    @ParameterizedTest
    @ValueSource(doubles = {2.53,15.58,16.98})
    public void testNewBalance(double arg){
        mybankAcc.deposit((float)arg);
        assertTrue(mybankAcc.getBalance() == (float)arg);
    }

    // assumtion: gia dinh dieu kien; test dieu kien;
    // truoc khi kiem tra funktion voi assertion
    @Test
    public void testOnDev(){
        System.setProperty("ENV","DEV");
        assumeTrue("DEV".equals(System.getProperty("ENV")));
    }

    // Set up for Uebung 6
    Bankaccount accA = new Bankaccount("A");
    Bankaccount accB = new Bankaccount("B");
    float xEuro = 1000;
    float transferedGeld = 200;

    // Test for A26(JUnit 5 - Tests) of Uebung 6
    /* meine Lösung
    @BeforeEach
    public void setUpBetragVonKonto(){
        accA.deposit(xEuro);
        accB.deposit(xEuro);
    }
    @Test
    public void testKonto(){
        assertNotNull(accA);
        assertNotNull(accB);
    }
    @Test
    public void testInitialeBetrag(){
        assertTrue(accA.getBalance() == xEuro);
        assertTrue(accB.getBalance() == xEuro);
    }
    @Test
    public void testTransfer(){
        accA.tranfer(200,accB);
        assertTrue(accA.getBalance() == 800);
        assertTrue(accB.getBalance() == 1200);
    }
    */
    /* Lösung von Dozent
    public void setUpBetragVonKonto(){
        accA.deposit(xEuro);
        accB.deposit(xEuro);
    }
    @Test
    @DisplayName("Transfer Money")
    public void testTransfer(){
        setUpBetragVonKonto();
        assertNotNull(accA);
        assertNotNull(accB);
        float aacACurrentBalance = accA.getBalance();
        float aacBCurrentBalance = accB.getBalance();
        assertEquals(xEuro,aacACurrentBalance);
        assertEquals(xEuro,aacBCurrentBalance);
        accA.tranfer(transferedGeld,accB);
        assertEquals(aacACurrentBalance-transferedGeld,accA.getBalance());
        assertEquals(aacBCurrentBalance+transferedGeld,accB.getBalance());
    }
    */

    // Test for A27 (Wiederholende JUnit5 Tests) - Uebung 6
    @BeforeEach
    public void setUpFortestTransfer10Times(){
        accA.deposit(xEuro);
        accB.deposit(xEuro);
        double max = accA.getBalance();
        transferedGeld = (float)ThreadLocalRandom.current().nextDouble(0.1,max);
    }
    @RepeatedTest(10)
    @DisplayName("Wiederholende Transfer Money Test")
    public void testTransfer10Times(){
        setUpFortestTransfer10Times();
        assertNotNull(accA);
        assertNotNull(accB);
        float aacACurrentBalance = accA.getBalance();
        float aacBCurrentBalance = accB.getBalance();
        try {
            accA.tranfer(transferedGeld, accB);
        }catch (NegativeKontostandException e){
            e.getMessage();
        }
        assertEquals(aacACurrentBalance-transferedGeld,accA.getBalance());
        assertEquals(aacBCurrentBalance+transferedGeld,accB.getBalance());
    }

    // Test for A28 (JUnit 5 - Tests zum Abfangen von Exceptions)
    Bankaccount myAccount = new Bankaccount("myAccount");
    Bankaccount targetAccount = new Bankaccount("targetAccount");
    public void setUpExceptions(){
        myAccount.deposit(xEuro);
        targetAccount.deposit(xEuro);
        transferedGeld = myAccount.getBalance() + ThreadLocalRandom.current().nextInt(0,Integer.MAX_VALUE);
    }
    public void setUpWithoutExceptions(){
        transferedGeld = myAccount.getBalance();
    }
    @Test
    @DisplayName("Exceptions Test")
    public void testExceptions(){
        setUpExceptions();
        assertNotNull(myAccount);
        assertNotNull(targetAccount);
        float myAccountCurrentBalance = myAccount.getBalance();
        float targetAccountCurrentBalance = targetAccount.getBalance();
        Exception testNegativeKontostandException = assertThrows(NegativeKontostandException.class,
                () -> {myAccount.tranfer(transferedGeld,targetAccount);});
        setUpWithoutExceptions();
        Exception testWithoutException = assertThrows(NegativeKontostandException.class,
                () -> {myAccount.tranfer(transferedGeld,targetAccount);});
    }
}
