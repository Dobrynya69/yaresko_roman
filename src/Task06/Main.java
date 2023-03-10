package Task06;
import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * A base class that calls other classes
 */
public class Main{
    /**
     * A method to run the program
     * @param args  the args
     */
    public static void main(String[] args) {
        App app = App.getInstance();
        app.run();
    }
}
