package by.epam.task4.factory;

import by.epam.task4.entity.Aircraft;
import by.epam.task4.entity.CargoAircraft;

public class CargoAircraftFactory implements IAircraftFactory {
    @Override
    public Aircraft createAircraft(String[] data) {
        CargoAircraft cargoAircraft = new CargoAircraft();
        cargoAircraft.setProducer(data[1]);
        cargoAircraft.setModel(data[2]);
        cargoAircraft.setCruisingSpeed(Integer.parseInt(data[3]));
        cargoAircraft.setFlightRange(Integer.parseInt(data[4]));
        cargoAircraft.setMaxHeight(Integer.parseInt(data[5]));
        cargoAircraft.setFuelConsumption(Double.parseDouble(data[6]));
        cargoAircraft.setLoadCapacity(Double.parseDouble(data[7]));
        return cargoAircraft;
    }
}
