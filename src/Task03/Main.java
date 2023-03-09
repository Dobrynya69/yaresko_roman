package Task03;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * A base class that calls other classes
 */
public class Main {
    private ViewResult view;

    public Main(ViewResult view) {
        this.view = view;
    }
    /**
     * Menu method for ease of use
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
                    int size = 2;
                    System.out.println("Enter your " + size + " numbers like this - +38 0xx xxx xx xx");
                    String[] numbers = new String[size];
                    for(int i = 0; i < size; i++) {
                        try {
                            numbers[i] = in.readLine();
                        } catch(IOException e) {
                            System.out.println("Error: " + e);
                            System.exit(0);
                        }
                    }
                    view.viewInit(numbers);
                    System.out.println(view.viewShow());
                    break;
                case 'S':
                    System.out.println("Save current.");
                    try {
                        view.viewSave();
                    } catch (IOException e) {
                        System.out.println("Serialization error: " + e);
                    }
                    System.out.println(view.viewShow());
                    break;
                case 'R':
                    System.out.println("Restore last saved.");
                    try {
                        view.viewRestore();
                    } catch (Exception e) {
                        System.out.println("Serialization error: " + e);
                    }
                    System.out.println(view.viewShow());
                    break;
                default:
                    System.out.print("Wrong command. ");
            }
        } while(s.charAt(0) != 'Q');
    }


    /**
     * A method to run the program
     * @param args  the args
     */
    public static void main(String[] args) {

        Main main = new Main(new ViewResult());
        main.menu();
    }
}
