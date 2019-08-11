package by.epam.task4.io;

import by.epam.task4.entity.Aircraft;
import by.epam.task4.entity.AircraftType;
import by.epam.task4.factory.CargoAircraftFactory;
import by.epam.task4.factory.IAircraftFactory;
import by.epam.task4.factory.PassengerAircraftFactory;
import by.epam.task4.parser.StringParser;
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
 *
 */
public class DataReader {

    private static final String FILE_NAME = "data/aircraft.txt";
    private static final Logger LOG = LogManager.getLogger(DataReader.class);

    /**
     *
     * @return
     */
    public List<Aircraft> readData() {
        List<Aircraft> aircraftList = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            StringParser stringParser = new StringParser();
            IAircraftFactory aircraftFactory = null;
            while((line = bufferedReader.readLine()) != null) {
                String[] result = stringParser.pars(line);
                String aircraftType = stringParser.getAircraftType(result);
                AircraftType type = AircraftType.valueOf(aircraftType.toUpperCase());
                DataValidator dataValidator = new DataValidator();
                switch (type) {
                    case CARGO:
                        if(dataValidator.isCargoAircraft(result)) {
                            aircraftFactory = new CargoAircraftFactory();
                            aircraftList.add(aircraftFactory.createAircraft(result));
                        }
                        break;
                    case PASSENGER:
                        if(dataValidator.isPassengerAircraft(result)) {
                            aircraftFactory = new PassengerAircraftFactory();
                            aircraftList.add(aircraftFactory.createAircraft(result));
                        }
                        break;
                    default:
                        LOG.info("Incorrect aircraft type");
                }
            }
        } catch(FileNotFoundException e) {
            LOG.error("File has not been found:" + FILE_NAME, e);
        } catch (IOException e) {
            LOG.error("Error of input stream");
        } catch (IllegalArgumentException e) {
            LOG.error("Data error");
        }
        return aircraftList;
    }

}
