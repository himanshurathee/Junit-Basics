import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestHello {
    @Test
    public void testsHello()
    {
        BasicCode code = new BasicCode();
        assertEquals( "Hello World!", code.sayHello());
    }
}
