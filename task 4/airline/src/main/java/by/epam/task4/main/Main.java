package by.epam.task4.main;

import by.epam.task4.entities.Aircraft;
import by.epam.task4.io.DataReader;

import java.util.List;

public class Main {

    public static void main( String[] args ) {
        DataReader dataReader = new DataReader();
        List<Aircraft> aircraftList= dataReader.readData();
        for(Aircraft aircraft: aircraftList) {
            System.out.println(aircraft.toString());
        }
    }
}
