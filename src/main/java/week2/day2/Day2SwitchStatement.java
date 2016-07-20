package week2.day2;

public class Day2SwitchStatement {

    private static int monthInt = 8;
    private static String monthString = "JULY";

    public static void main(String[] args) {
        System.out.println("The "+monthInt+"th month is "+intSwitchMonth(monthInt)+".");
        System.out.println(monthString+" is the "+StringSwitchMonth(monthString)+"th month of the year.");
    }

    private static String intSwitchMonth(int month) {
        String monthString = "";
        switch (month) {
            case 1:  monthString = "January";
                break;
            case 2:  monthString = "February";
                break;
            case 3:  monthString = "March";
                break;
            case 4:  monthString = "April";
                break;
            case 5:  monthString = "May";
                break;
            case 6:  monthString = "June";
                break;
            case 7:  monthString = "July";
                break;
            case 8:  monthString = "August";
                break;
            case 9:  monthString = "September";
                break;
            case 10: monthString = "October";
                break;
            case 11: monthString = "November";
                break;
            case 12: monthString = "December";
                break;
            default: monthString = "Invalid Month";
                break;
        }
        return monthString;
    }

    private static int StringSwitchMonth(String month) {
        int monthNumber = 0;
        if (month == null) {
            return monthNumber;
        }

        month = month.toLowerCase();

        switch (month) {
            case "january":
                monthNumber = 1;
                break;
            case "february":
                monthNumber = 2;
                break;
            case "march":
                monthNumber = 3;
                break;
            case "april":
                monthNumber = 4;
                break;
            case "may":
                monthNumber = 5;
                break;
            case "june":
                monthNumber = 6;
                break;
            case "july":
                monthNumber = 7;
                break;
            case "august":
                monthNumber = 8;
                break;
            case "september":
                monthNumber = 9;
                break;
            case "october":
                monthNumber = 10;
                break;
            case "november":
                monthNumber = 11;
                break;
            case "december":
                monthNumber = 12;
                break;
            default: monthNumber = 0;
                break;
        }
        return monthNumber;
    }
}
