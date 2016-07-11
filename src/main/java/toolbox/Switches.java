package toolbox;

public class Switches {

    // switches are an alternative to if-then-else statements when many flows can be chosen from a single value
    // a switch works with (primitives) char, byte, short  ----  (wrappers) Character, Byte, Short  ----  (Object) String

    // This method is an example of a very simple case
    public void intSwitch(int month) {
        // TODO: logic here
    }

    // allow the selected case to fall through where a block of cases have the same result and then break.
    // So if the month is 1, 3, 5, 7... they will all net the same result, numDays=31 and break.
    public void fallThroughCases(int month, int year) {
        // TODO: logic here
    }

    // The same thing, but using Strings instrad of ints. Requires Java 7 or greater
    public void stringSwitch(String dayOfWeek) {
        // TODO: logic here
    }
}