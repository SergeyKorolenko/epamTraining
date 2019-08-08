package by.epam.task4.factory;

import by.epam.task4.entities.Aircraft;

public interface IAircraftFactory {
    Aircraft createAircraft(String[] data);
}
