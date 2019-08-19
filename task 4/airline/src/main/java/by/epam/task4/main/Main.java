package by.epam.task4.main;

import by.epam.task4.entity.Airline;
import by.epam.task4.reader.DataReader;
import by.epam.task4.service.AirlineService;

/**
 * @author Sergei Korolenko
 */
public class Main {

    public static void main( String[] args ) {
        DataReader dataReader = new DataReader();
        Airline airline = new Airline(dataReader.readData());
        AirlineService.showList(airline.getAircraftList());
        AirlineService.bubbleSortByHeight(airline.getAircraftList());
        AirlineService.showList(airline.getAircraftList());
    }
}
