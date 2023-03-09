package Task05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * The class Change command implements console command
 */
public class ChangeCommand implements ConsoleCommand{
    private ViewTable view;

    /**
     * Change command constructor
     * @param view  the view
     * @return public
     */
    public ChangeCommand(ViewTable view) {

        this.view = view;
    }

    @Override
    /**
     * Gets the key
     * @return the key
     */
    public char getKey() {

        return 'C';
    }

    @Override
    /**
     * To string
     * @return String
     */
    public String toString() {

        return "(C)Change";
    }

    @Override
    /**
     * Execute
     */
    public void execute() {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Current numbers: ");
        for (Provider number:view.getItems()) {
            System.out.println("Enter a new number (the old is - " + number.getNumber() + ")");
            try {
                number.setNumber(in.readLine());
            } catch (IOException e){
                System.exit(0);
            }
        }
        System.out.println(view.viewShow());

    }
}

