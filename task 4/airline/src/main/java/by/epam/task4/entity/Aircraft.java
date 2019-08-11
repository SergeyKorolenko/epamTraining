package by.epam.task4.entity;

public class Aircraft{

    private String producer;
    private String model;
    private int cruisingSpeed;
    private int maxHeight;
    private int flightRange;
    private double fuelConsumption;

    public Aircraft() {
    }

    public Aircraft(String producer, String model, int cruisingSpeed, int maxHeight, int flightRange,
                    double fuelConsumption) {
        this.producer = producer;
        this.model = model;
        this.cruisingSpeed = cruisingSpeed;
        this.maxHeight = maxHeight;
        this.flightRange = flightRange;
        this.fuelConsumption = fuelConsumption;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCruisingSpeed() {
        return cruisingSpeed;
    }

    public void setCruisingSpeed(int cruisingSpeed) {
        this.cruisingSpeed = cruisingSpeed;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public int getFlightRange() {
        return flightRange;
    }

    public void setFlightRange(int flightRange) {
        this.flightRange = flightRange;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", cruisingSpeed=" + cruisingSpeed +
                ", maxHeight=" + maxHeight +
                ", flightRange=" + flightRange +
                ", fuelConsumption=" + fuelConsumption +
                ", ";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + cruisingSpeed;
        result = prime * result + flightRange;
        long temp;
        temp = Double.doubleToLongBits(fuelConsumption);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + maxHeight;
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        result = prime * result + ((producer == null) ? 0 : producer.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aircraft other = (Aircraft) obj;
        if (cruisingSpeed != other.cruisingSpeed)
            return false;
        if (flightRange != other.flightRange)
            return false;
        if (Double.doubleToLongBits(fuelConsumption) != Double.doubleToLongBits(other.fuelConsumption))
            return false;
        if (maxHeight != other.maxHeight)
            return false;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
        if (producer == null) {
            if (other.producer != null)
                return false;
        } else if (!producer.equals(other.producer))
            return false;
        return true;
    }

}
