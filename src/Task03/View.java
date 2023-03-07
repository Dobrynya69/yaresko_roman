package Task03;

import java.io.IOException;

/**
 * The interface View
 */
public interface View {
    public String viewShow();
    public String viewInit(String[] numbers);
    public void viewSave() throws IOException;
    public void viewRestore() throws Exception;
}
