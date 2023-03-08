package Task04;

import java.util.Formatter;


/**
 * The class View table extends view result
 */
public class ViewTable extends ViewResult {
    private static final int DEFAULT_WIDTH = 20;

    private int width;


    /**
     * View table
     * @return public
     */
    public ViewTable() {

        width = DEFAULT_WIDTH;
    }


    /**
     * View table
     * @param width  the width
     * @return public
     */
    public ViewTable(int width) {

        this.width = width;
    }


    /**
     * Gets the width
     * @return the width
     */
    public int getWidth() {

        return width;
    }


    /**
     * Sets the width
     * @param width  the width
     */
    public void setWidth(int width) {

        this.width = width;
    }


    /**
     * Out line
     */
    private void outLine(){

        for (int i = 0; i < width; i++){
            System.out.print("-");
        }
    }


    /**
     * Out header
     */
    private void outHeader() {

        Formatter fmt = new Formatter();
        fmt.format("%s%d%s%2$d%s", "%", (width-3)/2, "s | %", "s\n");
        System.out.printf(fmt.toString(), "Number", "Provider");
    }


    /**
     * Out body
     */
    private void outBody() {

        Formatter fmt = new Formatter();
        fmt.format("%s%d%s%2$d%s", "%", (width-3)/2, "s | %", "s\n");
        for(Provider item : getItems()) {
            System.out.printf(fmt.toString(), item.getNumber(), item.getProvider());
        }
    }



    /**
     * View init
     * @param numbers  the numbers
     * @param width  the width
     * @return String
     * @throws  //Overloading
    this.viewInit(numbers
     */
    public String viewInit(String[] numbers, int width){ //Overloading
        this.viewInit(numbers);
        this.width = width;
        return viewShow();
    }


    @Override
    public String viewShow() {

        outHeader();
        outLine();
        System.out.println();
        outBody();
        outLine();
        return "\n";
    }
}