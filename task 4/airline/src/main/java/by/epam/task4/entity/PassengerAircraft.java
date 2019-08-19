package by.epam.task4.entity;

/**
 * @author Sergei Korolenko
 */
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + capacity;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        PassengerAircraft other = (PassengerAircraft) obj;
        if (capacity != other.capacity)
            return false;
        return true;
    }
}
