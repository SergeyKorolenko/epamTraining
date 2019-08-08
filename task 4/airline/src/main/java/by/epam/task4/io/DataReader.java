package by.epam.task4.io;

import by.epam.task4.entities.Aircraft;
import by.epam.task4.entities.AircraftType;
import by.epam.task4.factory.CargoAircraftFactory;
import by.epam.task4.factory.IAircraftFactory;
import by.epam.task4.factory.PassengerAircraftFactory;
import by.epam.task4.parser.StringParser;
import by.epam.task4.validator.DataValidator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    public List<Aircraft> readData() {
        List<Aircraft> aircraftList = new ArrayList<>();
        String fileName = "data/aircraft.txt";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            StringParser stringParser = new StringParser();
            while((line = bufferedReader.readLine()) != null) {
                String[] result = stringParser.pars(line);
                String aircraftType = stringParser.getAircraftType(result);
                AircraftType type = AircraftType.valueOf(aircraftType.toUpperCase());
                DataValidator dataValidator = new DataValidator();
                IAircraftFactory aircraftFactory = null;
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
                }
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return aircraftList;
    }

}
