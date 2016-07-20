package week2.day1;

public class Day1TimesTable {

    public static void main(String[] args) {
        int tableSize = 12;
        printTimesTable(tableSize);
    }

    public static void printTimesTable(int tableSize) {
        // first print the top header row using a for-loop
        System.out.format("      ");
        for(int i = 1; i<=tableSize;i++ ) {
            System.out.format("%4d",i);
        }
        System.out.println();
        System.out.println("--------------------------------------------------------");

        // create another for-loop to start building the rows
        for(int x = 1; x<=tableSize; x++) {
            // print left most column first
            System.out.format("%4d |",x);
            // create another loop to fill in the multiplied columns
            for(int y = 1; y <= tableSize; y++) {
                System.out.format("%4d",y*x);
            }
            System.out.println();
        }
    }
}
