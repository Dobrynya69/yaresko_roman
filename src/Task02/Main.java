package Task02;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * A base class that calls other classes
 */
public class Main {
    private Calc calc = new Calc();

    /**
     *
     * Menu method for ease of use
     *
     */
    private void menu() {

        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            do {
                System.out.println("Make your choice...");
                System.out.print("(Q)Quit, (E)Enter number, (S)Save number, (R)Restore: ");
                try {
                    s = in.readLine();
                } catch(IOException e) {
                    System.out.println("Error: " + e);
                    System.exit(0);
                }
            } while (s.length() != 1);
            switch (s.charAt(0)) {
                case 'Q':
                    System.out.println("Quit.");
                    break;
                case 'E':
                    System.out.println("Enter your number like this - +38 0xx xxx xx xx");
                    String number;
                    try {
                        number = in.readLine();
                        calc.init(number);
                        calc.show();
                    } catch(IOException e) {
                        System.out.println("Error: " + e);
                        System.exit(0);
                    }
                    break;
                case 'S':
                    System.out.println("Save current.");
                    try {
                        calc.save();
                    } catch (IOException e) {
                        System.out.println("Serialization error: " + e);
                    }
                    calc.show();
                    break;
                case 'R':
                    System.out.println("Restore last saved.");
                    try {
                        calc.restore();
                    } catch (Exception e) {
                        System.out.println("Serialization error: " + e);
                    }
                    calc.show();
                    break;
                default:
                    System.out.print("Wrong command. ");
            }
        } while(s.charAt(0) != 'Q');
    }


    /**
     *
     * A method to run the program
     *
     * @param args  the args
     */
    public static void main(String[] args) {

        Main main = new Main();
        main.menu();
    }
}
