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

/**
 * @author Sergei Korolenko
 */
public class AirlineService {

    /**
     * This method calculates total capacity of all passenger aircraft.
     *
     * @param aircraftList the list to be calculated
     * @return total capacity of all passenger aircraft
     */
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

    /**
     *This method calculates total load capacity of all cargo aircraft.
     *
     * @param aircraftList the list to be calculated
     * @return total load capacity of all cargo aircraft
     */
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

    /**
     * This method searches an aircraft by fuel consumption.
     *
     * @param aircraftList the list to be searched
     * @param start lower bound for search
     * @param end upper bound for search
     * @return the list of aircraft satisfying the condition
     */
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

    /**
     * This method sorts a list of aircraft by producer.
     *
     * @param aircraftList the list to be sorted
     */
    public static void sortByProducer(List<Aircraft> aircraftList) {
        Comparator<Aircraft> comparator = new AircraftProducerComparator();
        aircraftList.sort(comparator);
    }

    /**
     * This method sorts a list of aircraft by producer and then by max height.
     *
     * @param aircraftList
     */
    public static void sortByProducerAndHeight(List<Aircraft> aircraftList) {
        Comparator<Aircraft> comparator = new AircraftProducerComparator().
                thenComparing(new AircraftHeightComparator());
        aircraftList.sort(comparator);
    }

    /**
     * This method prints a list of aircraft.
     *
     * @param aircraftList the list to be printed
     */
    public static void showList(List<Aircraft> aircraftList) {
        if(aircraftList.isEmpty()) {
            System.out.println("List is empty");
        } else {
            for (Aircraft aircraft : aircraftList) {
                System.out.println(aircraft);
            }
        }
    }

    /**
     * This method sorts a list of aircraft by max height using bubble sort method.
     *
     * @param aircraftList the list to be sorted
     */
    public static void bubbleSortByHeight(List<Aircraft> aircraftList) {
        for(int i = aircraftList.size() - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(aircraftList.get(j).getMaxHeight() > aircraftList.get(j+1).getMaxHeight()) {
                    Aircraft aircraft = aircraftList.get(j);
                    aircraftList.set(j, aircraftList.get(j+1));
                    aircraftList.set(j+1, aircraft);
                }
            }
        }
    }

}
