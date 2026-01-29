package uk.ac.cam.mr2083.sect7;

import org.jetbrains.annotations.NotNull;

public class Car implements Comparable<Car>{
    private String manufacturer;
    private int age;

    public Car(String manufacturer, int age) {
        if (age < 0) {
            throw new RuntimeException("Age must be greater than or equal to 0.");
        }

        this.manufacturer = manufacturer;
        this.age = age;
    }

    public Car(String manufacturer) {
        this.manufacturer = manufacturer;
        this.age = 0;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new RuntimeException("Age must be greater than or equal to 0.");
        }

        this.age = age;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public int compareTo(@NotNull Car o) {
        return this.manufacturer.compareTo(o.manufacturer);
    }
}
