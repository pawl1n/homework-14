package car;

public class Car implements Comparable<Car> {
    private final int yearOfManufacture; // year of manufacture cannot be changed
    private final int engineCapacity; // engine capacity cannot be changed

    public Car(int yearOfManufacture, int engineCapacity) {

        this.yearOfManufacture = yearOfManufacture;
        this.engineCapacity = engineCapacity;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(engineCapacity, o.engineCapacity);
    }

    @Override
    public String toString() {
        return "Car{" +
                "yearOfManufacture=" + yearOfManufacture +
                ", engineCapacity=" + engineCapacity +
                '}';
    }
}
