import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParameterizedTestTest {
    @ParameterizedTest
    @ValueSource(ints = {100, 400, 800, 1000})
    @DisplayName("Depositing successfully")

    public void testDeposit( int amount, BankAccount bankAccount){
        bankAccount.deposit(amount);
        assertEquals(amount,bankAccount.getBalance());
    }

    @ParameterizedTest
    @CsvSource({"100,Jon","10000,Niku","500, Rathee"})
    public void depositAndNameTest(double amount, String name, BankAccount bankAccount){
        bankAccount.deposit(amount);
        bankAccount.setHolderName(name);
        assertEquals(amount,bankAccount.getBalance());
        assertEquals(name,bankAccount.getHolderName());
    }
}
