package by.epam.task4.entities;

import java.util.Comparator;

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
}
