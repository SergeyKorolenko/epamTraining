package by.epam.task4.comparator;

import by.epam.task4.entity.Aircraft;

import java.util.Comparator;

/**
 * @author Sergei Korolenko
 */
public class AircraftHeightComparator implements Comparator<Aircraft> {

    @Override
    public int compare(Aircraft o1, Aircraft o2) {
        if(o1.getMaxHeight() > o2.getMaxHeight()) {
            return 1;
        } else if(o1.getMaxHeight() < o2.getMaxHeight()) {
            return -1;
        } else {
            return 0;
        }
    }
}
