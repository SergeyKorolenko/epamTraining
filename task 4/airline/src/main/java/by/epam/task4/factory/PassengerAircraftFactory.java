package by.epam.task4.factory;

import by.epam.task4.entities.Aircraft;
import by.epam.task4.entities.PassengerAircraft;

public class PassengerAircraftFactory implements IAircraftFactory {
    @Override
    public Aircraft createAircraft(String[] data) {
        PassengerAircraft passengerAircraft = new PassengerAircraft();
        passengerAircraft.setProducer(data[1]);
        passengerAircraft.setModel(data[2]);
        passengerAircraft.setCruisingSpeed(Integer.parseInt(data[3]));
        passengerAircraft.setFlightRange(Integer.parseInt(data[4]));
        passengerAircraft.setMaxHeight(Integer.parseInt(data[5]));
        passengerAircraft.setFuelConsumption(Double.parseDouble(data[6]));
        passengerAircraft.setCapacity(Integer.parseInt(data[7]));
        return passengerAircraft;
    }
}
