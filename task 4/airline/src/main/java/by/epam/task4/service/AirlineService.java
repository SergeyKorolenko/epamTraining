package by.epam.task4.service;

import by.epam.task4.comparator.AircraftHeightComparator;
import by.epam.task4.comparator.AircraftProducerComparator;
import by.epam.task4.entity.Aircraft;
import by.epam.task4.entity.CargoAircraft;
import by.epam.task4.entity.PassengerAircraft;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class AirlineService {

    public static int calculateFullCapacity(List<Aircraft> aircraftList) {
        Iterator<Aircraft> it = aircraftList.iterator();
        int sumCapacity = 0;
        while(it.hasNext()) {
            Aircraft aircraft = it.next();
            if(aircraft instanceof PassengerAircraft) {
                sumCapacity += ((PassengerAircraft) aircraft).getCapacity();
            }
        }
        return sumCapacity;
    }

    public static double calculateFullLoadCapacity(List<Aircraft> aircraftList) {
        Iterator<Aircraft> it = aircraftList.iterator();
        double sumLoadCapacity = 0.0;
        while(it.hasNext()) {
            Aircraft aircraft = it.next();
            if(aircraft instanceof CargoAircraft) {
                sumLoadCapacity += ((CargoAircraft) aircraft).getLoadCapacity();
            }
        }
        return sumLoadCapacity;
    }

    public static List<Aircraft> searchAircraftByFuelConsumption(List<Aircraft> aircraftList,
                                                                 double start, double end) {
        List<Aircraft> resultList = new ArrayList<>();
        Iterator<Aircraft> it = aircraftList.iterator();
        while(it.hasNext()) {
            Aircraft aircraft = it.next();
            if(aircraft.getFuelConsumption() >= start && aircraft.getFuelConsumption() <= end) {
                resultList.add(aircraft);
            }
        }
        return resultList;
    }

    public static void sortByProducer(List<Aircraft> aircraftList) {
        Comparator<Aircraft> comparator = new AircraftProducerComparator();
        aircraftList.sort(comparator);
    }

    public static void sortByProducerAndHeight(List<Aircraft> aircraftList) {
        Comparator<Aircraft> comparator = new AircraftProducerComparator().
                thenComparing(new AircraftHeightComparator());
        aircraftList.sort(comparator);
    }

    public static void showList(List<Aircraft> aircraftList) {
        for(Aircraft aircraft: aircraftList) {
            System.out.println(aircraft);
        }
    }

}
