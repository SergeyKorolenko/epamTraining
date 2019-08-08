package by.epam.task4.entities;

public class CargoAircraft extends Aircraft {

    private double loadCapacity;

    public CargoAircraft() {
    }

    public CargoAircraft(String producer, String model, int cruisingSpeed, int maxHeight, int flightRange,
                         double fuelConsumption, double loadCapacity) {
        super(producer, model, cruisingSpeed, maxHeight, flightRange, fuelConsumption);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return "CargoAircraft{" + super.toString() +
                "loadCapacity=" + loadCapacity +
                "} ";
    }
}
