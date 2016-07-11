package week2.day2;

public class Day2SwitchStatement {

    private static int monthInt = 8;
    private static String monthString = "July";

    public static void main(String[] args) {
        System.out.println("The "+monthInt+"th month is "+intSwitchMonth(monthInt)+".");
        System.out.println(monthString+" is the "+StringSwitchMonth(monthString)+"th month of the year.");
    }

    private static String intSwitchMonth(int month) {
        String monthString = "";
        // switch statement here
        return monthString;
    }

    private static int StringSwitchMonth(String month) {
        int monthNumber = 0;
        if (month == null) {
            return monthNumber;
        }

        // switch statement here
        return monthNumber;
    }
}
