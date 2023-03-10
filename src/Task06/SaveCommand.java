package Task06;

import java.io.IOException;

/**
 * The class Save command implements console command
 */
public class SaveCommand implements ConsoleCommand{
    private ViewTable view;

    /**
     * Save command
     * @param view  the view
     * @return public
     */
    public SaveCommand(ViewTable view) {

        this.view = view;
    }

    @Override
    /**
     * Gets the key
     * @return the key
     */
    public char getKey() {

        return 'S';
    }

    @Override
    /**
     * To string
     * @return String
     */
    public String toString() {

        return "(S)Save";
    }

    @Override
    /**
     * Execute
     */
    public void execute() {

        try {
            view.viewSave();
        } catch (IOException e){
            System.out.println("Serialization error: " + e);
        }
        System.out.println(view.viewShow());
    }
}
