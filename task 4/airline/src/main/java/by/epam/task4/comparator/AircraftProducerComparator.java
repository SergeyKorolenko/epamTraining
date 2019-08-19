package by.epam.task4.comparator;

import by.epam.task4.entity.Aircraft;

import java.util.Comparator;

/**
 * @author Sergei Korolenko
 */
public class AircraftProducerComparator implements Comparator<Aircraft> {

    @Override
    public int compare(Aircraft o1, Aircraft o2) {
        return  o1.getProducer().compareTo(o2.getProducer());
    }
}
