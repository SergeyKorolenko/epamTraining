package by.epam.task4.factory;

import by.epam.task4.entity.Aircraft;
import by.epam.task4.enums.AircraftType;

public interface IAircraftFactory {
    Aircraft createAircraft(AircraftType aircraftType, String[] data);
}
