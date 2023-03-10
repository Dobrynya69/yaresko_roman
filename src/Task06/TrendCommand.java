package Task06;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;


/**
 * The class Trend command implements command
 */
public class TrendCommand implements Command {
    private String[] result = new String[] {"There is no trend in this numbers!", "1"};

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
     * Trend command
     * @param viewResult  the view result
     * @return public
     */
    public TrendCommand(ViewResult viewResult) {

        this.viewResult = viewResult;
    }

    /**
     * Gets the result
     * @return the result
     */
    public String[] getResult() {

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
        System.out.println("Trend executed...");
        Map<String,Integer> trendNumbers = new TreeMap<>();
        for (Provider item : viewResult.getItems()) {
            boolean has = false;
            for (var trendNumber : trendNumbers.entrySet()){
                if (trendNumber.getKey().equals(item.getNumber())){
                    trendNumber.setValue(trendNumber.getValue() + 1);
                    if (Integer.parseInt(result[1]) < trendNumber.getValue()){
                        result = new String[]{trendNumber.getKey(), Integer.toString(trendNumber.getValue())};
                    }
                    System.out.println("Trend thread - the " + trendNumber.getKey() + " trend is " + trendNumber.getValue());
                    has = true;
                    break;
                }
            }
            if (!has){
                trendNumbers.put(item.getNumber(), 1);
                System.out.println("Trend thread - the " + item.getNumber() + " trend is 1");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        System.out.println("Trend done. Result = " + result[0]);
        works = false;
    }
}
