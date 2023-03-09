package Task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * The class Application
 */
public class App {
    private static App instance = new App();

    /**
     * Constructor and returning an instance object.
     */
    public static App getInstance() {
        return instance;
    }

    /**
     * Constructor and adding width parameter
     */
    private App() {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the width of the table, or print anything else if you want to set the default number: ");
        String str = "";
        try {
            str = in.readLine();
            this.view = new ViewTable(Integer.parseInt(str));
        } catch(Exception e) {
            this.view = new ViewTable();
        }
    }

    private ViewTable view;

    private Menu menu = new Menu();

    /**
     * Running and adding all commands
     */
    public void run() {

        menu.add(new ViewCommand(view));
        menu.add(new EnterCommand(view));
        menu.add(new ChangeCommand(view));
        menu.add(new SaveCommand(view));
        menu.add(new RestoreCommand(view));
        menu.execute();
    }
}
