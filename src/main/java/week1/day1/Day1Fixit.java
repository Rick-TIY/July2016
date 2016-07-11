package week1.day1;

public class Day1Fixit {

    private static int x = 12;
    private static int y = 28;
    private static double z = 3.3;

    public static void main(String[] args) {
        System.out.println("The answer to (x * y) / z is "+calculate());

    }

    private static double calculate() {
//        double d = (x * y) / z;
//        return d;
        return (x * y) / z;

    }
}
