import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountTimeOutTest {

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void testDepositTimeoutAssertion(BankAccount bankAccount){
    try{
        Thread.sleep(200);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
    bankAccount.deposit(1000);
    assertEquals(1000,bankAccount.getBalance());
    }
    @Test
    public void testDepositTimeoutAnnotation(BankAccount bankAccount){
        try{
            Thread.sleep(200);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        bankAccount.deposit(1000);
        assertTimeout(Duration.ofMillis(500), () -> {Thread.sleep(300);});
    }
}
