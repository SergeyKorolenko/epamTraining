package by.epam.task4.main;

import by.epam.task4.entity.Aircraft;
import by.epam.task4.io.DataReader;
import by.epam.task4.service.AirlineService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {

    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main( String[] args ) {
        LOG.info("Application has started");
        DataReader dataReader = new DataReader();
        List<Aircraft> aircraftList= dataReader.readData();
        AirlineService.showList(aircraftList);
        AirlineService.sortByProducerAndHeight(aircraftList);
        AirlineService.showList(aircraftList);

    }
}
