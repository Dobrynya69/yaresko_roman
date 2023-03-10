package Task06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 * The class Menu implements command
 */
public class Menu implements Command{
    private ArrayList<ConsoleCommand> menu = new ArrayList<ConsoleCommand>();

    /**
     * Add the command
     * @param command  the command
     * @return ConsoleCommand
     */
    public ConsoleCommand add(ConsoleCommand command) {

        menu.add(command);
        return command;
    }

    @Override
    /**
     * To string
     * @return String
     */
    public String toString() {

        String str = "Make your choice...\n";
        for (ConsoleCommand command : menu) {
            str += command + " | ";
        }
        str += "(Q)Quit: ";
        return str;
    }

    @Override
    /**
     * Execute
     */
    public void execute() {

        String str = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        mainMenu: while (true) {
            do {
                System.out.print(this);
                try {
                    str = in.readLine();
                } catch (IOException e) {
                    System.err.println("Error: " + e);
                    System.exit(0);
                }
            } while (str.length() != 1);
            char key = str.charAt(0);
            if (key == 'Q') {
                System.out.println("Exit.");
                break mainMenu;
            }

            for (ConsoleCommand command : menu) {
                if (str.charAt(0) == command.getKey()) {
                    command.execute();
                    continue mainMenu;
                }
            }
            System.out.println("Invalid command.");
        }
    }
}

