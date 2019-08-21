package by.epam.task4.exception;

public class StringFormatException extends Exception {

    public StringFormatException() {
    }

    public StringFormatException(String message) {
        super(message);
    }

    public StringFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public StringFormatException(Throwable cause) {
        super(cause);
    }
}
