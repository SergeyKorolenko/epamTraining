package by.epam.task4.service;

import by.epam.task4.entity.Aircraft;
import by.epam.task4.entity.CargoAircraft;
import by.epam.task4.entity.PassengerAircraft;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Sergei Korolenko
 */
public class AirlineServiceTest {

    private CargoAircraft aircraft1;
    private CargoAircraft aircraft2;
    private CargoAircraft aircraft3;
    private PassengerAircraft aircraft4;
    private PassengerAircraft aircraft5;
    private PassengerAircraft aircraft6;

    @Before
    public void setUp() throws Exception {
        aircraft1 = new CargoAircraft();
        aircraft2 = new CargoAircraft();
        aircraft3 = new CargoAircraft();
        aircraft4 = new PassengerAircraft();
        aircraft5 = new PassengerAircraft();
        aircraft6 = new PassengerAircraft();
    }

    @After
    public void tearDown() throws Exception {
        aircraft1 = null;
        aircraft2 = null;
        aircraft3 = null;
        aircraft4 = null;
        aircraft5 = null;
        aircraft6 = null;
    }

    @Test
    public void calculateFullCapacity() {
        aircraft4.setCapacity(150);
        aircraft5.setCapacity(72);
        aircraft6.setCapacity(85);
        List<Aircraft> list = new ArrayList<>();
        list.add(aircraft4);
        list.add(aircraft5);
        list.add(aircraft6);
        assertEquals(AirlineService.calculateFullCapacity(list), 307);
    }

    @Test
    public void calculateFullLoadCapacity() {
        aircraft1.setLoadCapacity(23.5);
        aircraft2.setLoadCapacity(35.2);
        aircraft3.setLoadCapacity(16.4);
        List<Aircraft> list = new ArrayList<>();
        list.add(aircraft1);
        list.add(aircraft2);
        list.add(aircraft3);
        System.out.println(AirlineService.calculateFullLoadCapacity(list));
        assertEquals(AirlineService.calculateFullLoadCapacity(list), 75.1, 0.0);
    }
}