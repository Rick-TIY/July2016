package week2.day1;

public class Day1FizzBuzz {

    public static void main(String[] args) {
//        thisWay();
        thatWay();
    }

    public static void thisWay() {
        String returnThis = "";
        // count from 1 to 100 (loop?)
        for(int i = 1; i<=100; i++) {
            returnThis = "";
            // check if divisible by 3 -- print Fizz
            if (i % 3 == 0) {
                returnThis += "Fizz";
            }
            // check if divisible by 5 -- print Buzz
            if (i % 5 == 0) {
                returnThis += "Buzz";
            }

            //if we have a word, print it, else print the number
            if (returnThis.isEmpty()) {
                System.out.println(i);
            } else {
                System.out.println(returnThis);
            }
        }
    }

    public static void thatWay() {
        // count from 1 to 100 (loop?)
        for(int i = 1; i<=100; i++) {


            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else {
                System.out.println(i);
            }
        }
    }
}
