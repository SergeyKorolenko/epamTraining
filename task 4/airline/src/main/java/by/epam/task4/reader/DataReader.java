package by.epam.task4.reader;

import by.epam.task4.entity.Aircraft;
import by.epam.task4.enums.AircraftType;
import by.epam.task4.factory.AircraftFactory;
import by.epam.task4.factory.IAircraftFactory;
import by.epam.task4.validator.DataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Korolenko
 */
public class DataReader {

    private static final String FILE_NAME = "data/aircraft.txt";
    private static final String SPLITERATOR = ",";
    private static final Logger LOG = LogManager.getLogger(DataReader.class);

    /**
     *This method reads aircraft data from the file and writes this data to the list.
     *
     * @return the list of aircraft
     */
    public List<Aircraft> readData() {
        List<Aircraft> aircraftList = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = null;
            IAircraftFactory aircraftFactory = new AircraftFactory();
            DataValidator dataValidator = new DataValidator();
            while((line = bufferedReader.readLine()) != null) {
                try {
                    String[] data = line.split(SPLITERATOR);
                    AircraftType type = AircraftType.valueOf(data[0].toUpperCase());
                    Aircraft aircraft = null;
                    switch (type) {
                        case CARGO:
                            if (dataValidator.isAircraft(type, data)) { ;
                                aircraftList.add(aircraftFactory.createAircraft(type, data));
                            }
                            break;
                        case PASSENGER:
                            if (dataValidator.isAircraft(type, data)) {
                                aircraftList.add(aircraftFactory.createAircraft(type, data));
                            }
                            break;
                    }
                } catch (Exception e) {
                    LOG.error("Incorrect aircraft type", e);
                }
            }
        } catch(FileNotFoundException e) {
            LOG.error("File has not been found:" + FILE_NAME, e);
        } catch (IOException e) {
            LOG.error("Error of input stream", e);
        }
        return aircraftList;
    }

}
