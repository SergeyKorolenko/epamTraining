package by.epam.task4.validator;

import by.epam.task4.entity.Aircraft;
import by.epam.task4.enums.AircraftType;
import by.epam.task4.exception.AircraftParameterException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Sergei Korolenko
 */
public class DataValidator {

    private static final Logger LOG = LogManager.getLogger(DataValidator.class);

    /**
     * This method checks aircraft data for correctness.
     *
     * @param type the aircraft type
     * @param data the array which contains aircraft data
     * @return true if aircraft data are correct; false otherwise
     */
    public boolean isAircraft(AircraftType type, String[] data) {
        try {
            int cruisingSpeed = Integer.parseInt(data[3]);
            int maxHeight = Integer.parseInt(data[4]);
            int flightRange = Integer.parseInt(data[5]);
            double fuelConsumption = Double.parseDouble(data[6]);
            switch (type) {
                case CARGO:
                    double loadCapacity = Double.parseDouble(data[7]);
                    if(cruisingSpeed <= 0 || maxHeight <= 0 || flightRange <= 0 ||
                            fuelConsumption <= 0.0 || loadCapacity <= 0.0) {
                        LOG.info("Incorrect data value");
                        throw new AircraftParameterException();
                    }
                    break;
                case PASSENGER:
                    int capacity = Integer.parseInt(data[7]);
                    if(cruisingSpeed <= 0 || maxHeight <= 0 || flightRange <= 0 || fuelConsumption <= 0.0 ||
                            capacity <= 0) {
                        LOG.error("Incorrect data value");
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
            return false;
        }
        return true;
    }
}
