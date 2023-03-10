package Task06;


/**
 * The class Restore command implements console command
 */
public class RestoreCommand implements ConsoleCommand{
    private ViewTable view;

    /**
     * Restore command
     * @param view  the view
     * @return public
     */
    public RestoreCommand(ViewTable view) {

        this.view = view;
    }

    @Override
    /**
     * Gets the key
     * @return the key
     */
    public char getKey() {

        return 'R';
    }

    @Override
    /**
     * To string
     * @return String
     */
    public String toString() {

        return "(R)Restore";
    }

    @Override
    /**
     * Execute
     */
    public void execute() {

        try {
            view.viewRestore();
        } catch (Exception e){
            System.out.println("Deserialization error: " + e);
        }
        System.out.println(view.viewShow());
    }
}
