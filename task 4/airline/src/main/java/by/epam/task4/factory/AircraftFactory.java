package by.epam.task4.factory;

import by.epam.task4.entity.Aircraft;
import by.epam.task4.entity.CargoAircraft;
import by.epam.task4.entity.PassengerAircraft;
import by.epam.task4.enums.AircraftType;

public class AircraftFactory implements IAircraftFactory {

    @Override
    public Aircraft createAircraft(AircraftType aircraftType, String[] data) {
        Aircraft aircraft = null;
        switch (aircraftType) {
            case CARGO:
                aircraft = new CargoAircraft(data[1], data[2], Integer.parseInt(data[3]),
                        Integer.parseInt(data[4]), Integer.parseInt(data[5]), Double.parseDouble(data[6]),
                        Double.parseDouble(data[7]));
                break;
            case PASSENGER:
                aircraft = new PassengerAircraft(data[1], data[2], Integer.parseInt(data[3]),
                        Integer.parseInt(data[4]), Integer.parseInt(data[5]), Double.parseDouble(data[6]),
                        Integer.parseInt(data[7]));
                break;
        }
        return aircraft;
    }
}
