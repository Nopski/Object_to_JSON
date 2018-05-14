/**
 * This is my exception which extended from class Exception
 */
public class MyException extends Exception {
    /**
     * empty class
     */
    public MyException() {}

    /**
     * class with parameter
     * @param message
     */
    public MyException(String message) {
        super(message);
    }
}