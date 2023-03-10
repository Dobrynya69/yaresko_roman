package Task06;

import java.util.concurrent.TimeUnit;


/**
 * The class Wrong command implements command
 */
public class WrongCommand implements Command {
    private int result = 0;

    private boolean works = false;

    private ViewResult viewResult;

    /**
     * Gets the view result
     * @return the view result
     */
    public ViewResult getViewResult() {

        return viewResult;
    }

    /**
     * Sets the view result
     * @param viewResult  the view result
     * @return ViewResult
     */
    public ViewResult setViewResult(ViewResult viewResult) {

        return this.viewResult = viewResult;
    }

    /**
     * Wrong command
     * @param viewResult  the view result
     * @return public
     */
    public WrongCommand(ViewResult viewResult) {

        this.viewResult = viewResult;
    }

    /**
     * Gets the result
     * @return the result
     */
    public int getResult() {

        return result;
    }

    /**
     * Running
     * @return boolean
     */
    public boolean running() {

        return works;
    }

    @Override
    /**
     * Execute
     */
    public void execute() {

        works = true;
        System.out.println("Search wrong numbers executed...");
        for (Provider item : viewResult.getItems()) {
            if (item.getNumber() == "Invalid number"){
                result += 1;
                System.out.println("Search wrong numbers - +1 wrong number");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        System.out.println("Search wrong numbers done. Result = " + result);
        works = false;
    }
}
