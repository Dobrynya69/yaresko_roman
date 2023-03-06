package Task02;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.IOException;


/**
 * A class for testing the operability and accuracy of the program
 */
public class MainTest {
    @Test

/**
 *
 * Testing the main functionality of the program
 *
 */
    public void testCalc() {

        Calc calc = new Calc();
        calc.init("+38 099 042 65 92");
        assertEquals("+38 099 042 65 92 - Vodafone", calc.getResult().toString());
        calc.init("+38 067 042 65 92");
        assertEquals("+38 067 042 65 92 - Kyivstar", calc.getResult().toString());
        calc.init("+38 063 042 65 92");
        assertEquals("+38 063 042 65 92 - Lifecell", calc.getResult().toString());
    }

    @Test

/**
 *
 * Testing serialization and deserialization of the program
 *
 */
    public void testRestore() {

        Calc calc = new Calc();
        calc.init("+38 099 042 65 92");
        try {
            calc.save();
        } catch (IOException e) {
            System.out.println("Serialization error: " + e);
        }

        calc.init("+38 067 042 65 92");

        try {
            calc.restore();
        } catch (Exception e) {
            System.out.println("Serialization error: " + e);
        }
        assertEquals("+38 099 042 65 92 - Vodafone", calc.getResult().toString());
    }
}
