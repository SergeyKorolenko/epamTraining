package by.epam.task4.entities;

public class PassengerAircraft extends Aircraft {

    private int capacity;

    public PassengerAircraft() {
    }

    public PassengerAircraft(String producer, String model, int cruisingSpeed, int maxHeight, int flightRange,
                             double fuelConsumption, int capacity) {
        super(producer, model, cruisingSpeed, maxHeight, flightRange, fuelConsumption);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "PassengerAircraft{" + super.toString() +
                "capacity=" + capacity +
                "} ";
    }
}
