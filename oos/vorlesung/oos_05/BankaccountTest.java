package oos.vorlesung.oos_05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class BankaccountTest {
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

    // assumtion: gia dinh dieu kien; test dieu kien;
    // truoc khi kiem tra funktion voi assertion
    @Test
    public void testOnDev(){
        System.setProperty("ENV","DEV");
        assumeTrue("DEV".equals(System.getProperty("ENV")));
    }

    @ParameterizedTest
    @ValueSource(doubles = {2.53,15.58,16.98})
    public void testNewBalance(double arg){
        mybankAcc.deposit((float)arg);
        assertTrue(mybankAcc.getBalance() == (float)arg);
    }

    Bankaccount accA = new Bankaccount("A");
    Bankaccount accB = new Bankaccount("B");
    float xEuro = 1000;
    float transferedGeld = 200;
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
    // Lösung von Dozent
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
        assertEquals(xEuro-transferedGeld,accA.getBalance());
        assertEquals(xEuro+transferedGeld,accB.getBalance());
    }
}
