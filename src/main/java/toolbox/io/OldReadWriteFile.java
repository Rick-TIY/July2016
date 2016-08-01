package toolbox.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OldReadWriteFile {
    public static void main(String[] args) throws IOException {
        File myFile = new File("Names.txt");

        // write content to file using IO libraries
        FileWriter fileWriter = new FileWriter(myFile);
        fileWriter.write("Alice1"); // overwrites file
//        fileWriter.write("Alice2\n"); // overwrites file
//        fileWriter.write("Alice3\n"); // overwrites file
        fileWriter.append("Bob1");
//        fileWriter.append("Bob2\n");
//        fileWriter.append("Bob3\n");
        fileWriter.append("Charlie");
        fileWriter.close();

        // read line-by-line
        Scanner scanner = new Scanner(myFile);
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }

        // read entire file
        scanner = new Scanner(myFile);
        scanner.useDelimiter("\\Z");
        String contents = scanner.next();
        System.out.println(contents);
    }
}
