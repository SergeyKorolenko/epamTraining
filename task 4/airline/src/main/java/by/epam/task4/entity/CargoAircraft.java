package by.epam.task4.entity;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(loadCapacity);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        CargoAircraft other = (CargoAircraft) obj;
        if (Double.doubleToLongBits(loadCapacity) != Double.doubleToLongBits(other.loadCapacity))
            return false;
        return true;
    }
}
