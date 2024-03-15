import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountBeforeAndAfterTest {
    static BankAccount bankAccount;
    @BeforeAll
    public static void startTest(){
       bankAccount = new BankAccount(500,0);
    }

    @Test

    public void testWithdraw(){
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }
    @Test

    public void testDeposit(){
        bankAccount.deposit(1000);
        assertEquals(1200, bankAccount.getBalance());
    }

    @AfterAll
    public static void endTest(){
        System.out.println("Bye!");
    }
}
