package Task05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The class Enter command implements console command
 */
public class EnterCommand implements ConsoleCommand{
    private ViewTable view;


    /**
     * Enter command
     * @param view  the view
     * @return public
     */
    public EnterCommand(ViewTable view) {

        this.view = view;
    }

    @Override
    /**
     * Gets the key
     * @return the key
     */
    public char getKey() {

        return 'E';
    }

    @Override
    /**
     *
     * To string
     *
     * @return String
     */
    public String toString() {

        return "(E)Enter";
    }

    @Override
    /**
     *
     * Execute
     *
     */
    public void execute() {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter an amount of numbers which you want to enter or type anything else if you want to enter 2 numbers");
        int size;
        try {
            size = Integer.parseInt(in.readLine());
        } catch(Exception e) {
            size = 2;
        }

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
        System.out.print(view.viewInit(numbers));
    }
}
