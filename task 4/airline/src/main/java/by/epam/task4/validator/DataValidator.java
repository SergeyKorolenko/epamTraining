package by.epam.task4.validator;

import by.epam.task4.entity.Aircraft;
import by.epam.task4.enums.AircraftType;
import by.epam.task4.exception.AircraftParameterException;
import by.epam.task4.exception.StringFormatException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.security.krb5.internal.PAData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sergei Korolenko
 */
public class DataValidator {

    private static final Logger LOG = LogManager.getLogger(DataValidator.class);
    private static final String PRODUCER_REG = "[a-zA-Z]+";
    private static final String MODEL_REG = "[a-zA-Z0-9-]+";

    /**
     * This method checks aircraft data for correctness.
     *
     * @param type the aircraft type
     * @param data the array which contains aircraft data
     * @return true if aircraft data are correct; false otherwise
     */
    public boolean isAircraft(AircraftType type, String[] data) {
        try {
            Pattern prodPattern = Pattern.compile(PRODUCER_REG);
            Matcher prodMatcher = prodPattern.matcher(data[1]);
            Pattern modPattern = Pattern.compile(MODEL_REG);
            Matcher modMatcher = modPattern.matcher(data[2]);
            if(!prodMatcher.matches() || !modMatcher.matches()) {
                throw new StringFormatException();
            }
            int cruisingSpeed = Integer.parseInt(data[3]);
            int maxHeight = Integer.parseInt(data[4]);
            int flightRange = Integer.parseInt(data[5]);
            double fuelConsumption = Double.parseDouble(data[6]);
            switch (type) {
                case CARGO:
                    double loadCapacity = Double.parseDouble(data[7]);
                    if(cruisingSpeed <= 0 || maxHeight <= 0 || flightRange <= 0 ||
                            fuelConsumption <= 0.0 || loadCapacity <= 0.0) {
                        throw new AircraftParameterException();
                    }
                    break;
                case PASSENGER:
                    int capacity = Integer.parseInt(data[7]);
                    if(cruisingSpeed <= 0 || maxHeight <= 0 || flightRange <= 0 || fuelConsumption <= 0.0 ||
                            capacity <= 0) {
                        throw new AircraftParameterException();
                    }
            }
        } catch (NumberFormatException e) {
            LOG.error("Incorrect data type", e);
            return false;
        } catch (IndexOutOfBoundsException e) {
            LOG.error("Data insufficiency", e);
            return false;
        } catch(AircraftParameterException e) {
            LOG.error("Incorrect numeric parameters ", e);
            return false;
        } catch (StringFormatException e) {
            LOG.error("Incorrect string parameters ", e);
            return false;
        }
        return true;
    }
}
