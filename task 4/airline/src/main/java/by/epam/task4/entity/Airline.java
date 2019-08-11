package by.epam.task4.entity;

import java.util.List;

public class Airline {

    private List<Aircraft> aircraftList;

    public Airline() {
    }

    public Airline(List<Aircraft> aircraftList) {
        this.aircraftList = aircraftList;
    }

    public List<Aircraft> getAircraftList() {
        return aircraftList;
    }

    public void setAircraftList(List<Aircraft> aircraftList) {
        this.aircraftList = aircraftList;
    }
}
