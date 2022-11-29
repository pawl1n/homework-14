package range;

public class RangeDriver {
    public static void main(String[] args) {
        for (Integer integer : new Range(1, 100)) {
            System.out.println(integer);
        }

        for (Integer integer : new RangeWithStep(1, 10, 2)) {
            System.out.println(integer);
        }
    }
}
