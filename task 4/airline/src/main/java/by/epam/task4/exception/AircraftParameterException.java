package by.epam.task4.exception;

/**
 * @author Sergei Korolenko
 */
public class AircraftParameterException extends Exception {

    public AircraftParameterException() {
    }

    public AircraftParameterException(String message) {
        super(message);
    }

    public AircraftParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public AircraftParameterException(Throwable cause) {
        super(cause);
    }
}
