package Task05;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



/**
 * The class View result implements view
 */
public class ViewResult implements View {
    private static final String FILENAME = "LastSaveTask03.bin";

    private ArrayList<Provider> items = new ArrayList<>();


    /**
     * Gets the items
     * @return the items
     */
    public ArrayList<Provider> getItems() {

        return items;
    }


    /**
     * View init
     * @param numbers  the numbers
     * @return String
     */
    public String viewInit(String[] numbers) {

        for(int i = 0; i < numbers.length; i++) {
            items.add(new Provider(numbers[i]));
        }
        return viewShow();
    }


    /**
     * View show
     * @return String
     */
    public String viewShow(){

        String result = "Numbers: ";
        for(int i = 0; i < items.size(); i++) {
            result += "\n" + items.get(i).toString();
        }
        return  result;
    };


    /**
     * View save
     * @param IOException{  the  IO exception{
     * @throws   IOException
     */
    public void viewSave() throws IOException{

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FILENAME));
        os.writeObject(items);
        os.flush();
        os.close();
    };


    /**
     * View restore
     * @param Exception{  the exception{
     * @throws   Exception
     */
    public void viewRestore() throws Exception{

        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FILENAME));
        items = (ArrayList<Provider>) is.readObject();
        is.close();
    };

}