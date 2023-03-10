package Task06;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.ArrayList;


/**
 * A class for testing the operability and accuracy of the program
 */
public class MainTest {
    @Test

/**
 * Testing the main functionality of the program
 */
    public void testCalc() {
        ViewResult view = new ViewResult();
        String[] numbers = new String[]{"+38 099 042 65 92", "+38 067 042 65 92", "+38 063 042 65 92"};
        view.viewInit(numbers);
        assertEquals(view.viewShow(), "Numbers: \n+38 099 042 65 92 - Vodafone\n+38 067 042 65 92 - Kyivstar\n+38 063 042 65 92 - Lifecell");
    }

    @Test

/**
 * Testing serialization and deserialization of the program
 */
    public void testRestore() {
        ViewResult view = new ViewResult();
        view.viewInit(new String[]{"+38 099 042 65 92", "+38 067 042 65 92", "+38 063 042 65 92"});
        try {
            view.viewSave();
        } catch (IOException e) {
            System.out.println("Serialization error: " + e);
        }
        view.viewInit(new String[]{"+38 098 042 65 92", "+38 068 042 65 92", "+38 060 042 65 92"});
        try {
            view.viewRestore();
        } catch (Exception e) {
            System.out.println("Deserialization error: " + e);
        }
        assertEquals(view.viewShow(), "Numbers: \n+38 099 042 65 92 - Vodafone\n+38 067 042 65 92 - Kyivstar\n+38 063 042 65 92 - Lifecell");
    }

    @Test

    /**
     * Testing the change functionality of the project
     */
    public void testChange() {
        ViewResult view = new ViewResult();
        String[] numbers = new String[]{"+38 099 042 65 92", "+38 067 042 65 92", "+38 063 042 65 92"};
        view.viewInit(numbers);
        numbers = new String[]{"+38 067 042 65 92", "+38 067 042 65 92", "+38 067 042 65 92"};
        ArrayList<Provider> changeableNumbers = view.getItems();
        changeableNumbers.get(0).setNumber(numbers[0]);
        changeableNumbers.get(1).setNumber(numbers[1]);
        changeableNumbers.get(2).setNumber(numbers[2]);
        assertEquals(view.viewShow(), "Numbers: \n+38 067 042 65 92 - Kyivstar\n+38 067 042 65 92 - Kyivstar\n+38 067 042 65 92 - Kyivstar");
    }

    @Test

    /**
     * Testing the find trend functionality of the project
     */
    public void testTrend() {
        ViewResult view = new ViewResult();
        String[] numbers = new String[]{"+38 099 042 65 92", "+38 099 042 65 92", "+38 063 042 65 92"};
        view.viewInit(numbers);
        TrendCommand trendCommand = new TrendCommand(view);
        trendCommand.execute();
        assertEquals(trendCommand.getResult()[0], new String[]{"+38 099 042 65 92", "2"}[0]);
    }

    @Test

    /**
     * Testing the find the wrong number functionality of the project
     */
    public void testWrong() {
        ViewResult view = new ViewResult();
        String[] numbers = new String[]{"laskdnlaks", "+38 099 042 65 92", "alskdnla"};
        view.viewInit(numbers);
        WrongCommand wrongCommand = new WrongCommand(view);
        wrongCommand.execute();
        assertEquals(wrongCommand.getResult(), 2);
    }
}
