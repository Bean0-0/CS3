import java.io.File;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.util.Scanner;

public class ReadFile {

    public static void main(String[] args) {
        String filename = "test.txt";

        try {
            // Create a File object for the file to be read
            File file = new File(filename);

            // Create a Scanner object to read the file
            Scanner scanner = new Scanner(file);

            // Read the contents of the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            System.out.println("Error reading file: " + filename);
        }
    }
}

