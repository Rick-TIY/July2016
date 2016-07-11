package week2.day1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day1Palindrome {

    public static void main(String[] args) {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println("Enter a word to test. Use 'exit' to stop application");
        while(true) {
            try {
                String inputString = bufferedReader.readLine();

                // TODO: logic

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean isPalindromeArrayLoop(String inputString) {
        boolean isPalindrome = false;
        //reverse inputString using an array loop and see if there is a match

        // TODO: logic

        return isPalindrome;
    }

    private static boolean isPalindromeStringBuilder(String inputString) {
        boolean isPalindrome = false;
        //reverse inputString using StringBuilder and see if it matches itself

        // TODO: logic

        return isPalindrome;
    }
}
