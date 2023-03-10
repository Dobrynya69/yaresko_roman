package Task06;


/**
 * The class View command implements console command
 */
public class ViewCommand implements ConsoleCommand{
    private ViewTable view;

    /**
     * View command
     * @param view  the view
     * @return public
     */
    public ViewCommand(ViewTable view) {

        this.view = view;
    }

    @Override
    /**
     * Gets the key
     * @return the key
     */
    public char getKey() {

        return 'V';
    }

    @Override
    /**
     * To string
     * @return String
     */
    public String toString() {

        return "(V)View";
    }

    @Override
    /**
     * Execute
     */
    public void execute() {

        System.out.println(view.viewShow());
    }
}

