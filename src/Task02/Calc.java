package Task02;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * A class in which an instance of the class is serialized and deserialized
 */
public class Calc {
    private static final String FILENAME = "LastSave.bin";

    private Provider result;


    /**
     *
     * Basic constructor without parameters
     *
     */
    public Calc() {

        result = new Provider();
    }


    /**
     *
     * Setter for the result
     *
     * @param result  the result
     */
    public void setResult(Provider result) {

        this.result = result;
    }


    /**
     *
     * Getter for the result
     *
     * @return the result
     */
    public Provider getResult() {

        return result;
    }


    /**
     *
     * A method that starts the main functionality of the program
     *
     * @param number  the number
     * @return String
     */
    public String init(String number ) {

        result = new Provider(number);
        return result.getProvider();
    }


    /**
     *
     * Method for deriving the result
     *
     */
    public void show() {

        System.out.println(result.getNumber() + " - " + result.getProvider());
    }


    /**
     *
     * A method for data serialization
     *
     * @param IOException  the  IO exception
     * @throws   IOException
     */
    public void save() throws IOException {

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FILENAME));
        os.writeObject(result);
        os.flush();
        os.close();
    }


    /**
     *
     * A method for deserializing and storing data
     *
     * @param Exception  the exception
     * @throws   Exception
     */
    public void restore() throws Exception {

        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FILENAME));
        result = (Provider)is.readObject();
        is.close();
    }
}