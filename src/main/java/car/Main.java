package car;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Car[] carArray = {
                new Car(2017, 1398),
                new Car(2005, 1596),
                new Car(2011, 1386),
                new Car(2011, 1596),
                new Car(2015, 1798)
        };

        ArrayList<Car> carList = new ArrayList<>(List.of(carArray));
        System.out.println(carList);
        Comparator<Car> byYearOfManufacture = Comparator.comparing(Car::getYearOfManufacture);
        carList.sort(byYearOfManufacture);
        System.out.println(carList);

        TreeSet<Car> carTreeSet = new TreeSet<>(List.of(carArray)); // won't add the cars with the same engine capacity
        System.out.println(carTreeSet);
    }
}