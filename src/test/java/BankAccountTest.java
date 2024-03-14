import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test BankAccount Class")
public class BankAccountTest {
    @Test
    @DisplayName("Withdraw 500 successfully")
    public void testWithdraw(){
        BankAccount bankAccount = new BankAccount(500,-1000);
        bankAccount.withdraw(300);
        assertEquals(200,bankAccount.getBalance());
    }
    @Test
    @DisplayName("Deposit 500 successfully")
    public void testDeposit(){
        BankAccount bankAccount = new BankAccount(400,0);
        bankAccount.deposit(500);
        assertEquals(900,bankAccount.getBalance());
    }
    @Test
    @DisplayName("Withdraw will become negative")
    public void testWithdrawNotStuckAtZero(){
        BankAccount bankAccount = new BankAccount(500,-1000);
        bankAccount.withdraw(800);
        assertNotEquals(0,bankAccount.getBalance());

    }
    @Test
    @DisplayName("Test Activation account after creation")
    public void testIsActive(){
        BankAccount bankAccount = new BankAccount(500,0);
        assertTrue(bankAccount.isActive());
    }
    @Test
    @DisplayName("Test set HolderName")
    public void testHolderNameSet(){
        BankAccount bankAccount = new BankAccount(500,-1000);
        bankAccount.setHolderName("Jon");
        assertNotNull(bankAccount.getHolderName());
    }
    @Test
    @DisplayName("Can not withdraw below minimum")
    public void testNoWithdrawBelowMinimum(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertThrows(RuntimeException.class, () -> bankAccount.withdraw(2000));
    }
    @Test
    @DisplayName("Test no exception for deposit and withdraw")
    public void testWithdrawAndDepositWithoutExceptions(){
        BankAccount bankAccount = new BankAccount(500,-1000);
        assertAll(()-> bankAccount.deposit(200),()->bankAccount.withdraw(500));
    }
    @Test
    @DisplayName("Test Speed Deposit")
    public void depositTimeout(){
        BankAccount bankAccount = new BankAccount(400,0);
        assertTimeout(Duration.ofNanos(1), ()-> bankAccount.deposit(5000));
    }
}
