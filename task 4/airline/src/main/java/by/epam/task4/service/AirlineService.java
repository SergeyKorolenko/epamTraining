package by.epam.task4.service;

import by.epam.task4.entities.Aircraft;
import by.epam.task4.entities.CargoAircraft;
import by.epam.task4.entities.PassengerAircraft;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AirlineService {

    public static void sort() {

    }

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

    public static List<Aircraft> searchAircraftByFuelConsumption(List<Aircraft> aircraftList, double start, double end) {
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

    public static void sort(List<Aircraft> aircraftList) {
       //Collections.sort(aircraftList);
    }

}
