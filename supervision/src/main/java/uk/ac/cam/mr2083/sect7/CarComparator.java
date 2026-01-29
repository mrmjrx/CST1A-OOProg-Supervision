package uk.ac.cam.mr2083.sect7;

import java.util.Comparator;

public class CarComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        int manufacturerComparison = o1.getManufacturer().compareTo(o2.getManufacturer());

        return manufacturerComparison == 0
                ? Comparator.comparingInt(Car::getAge).compare(o1, o2)
                : manufacturerComparison;
    }
}
