package by.epam.task4.factory;

import by.epam.task4.entity.Aircraft;

public interface IAircraftFactory {
    Aircraft createAircraft(String[] data);
}
