package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileWrite {
    public static void main(String[] args) {
        String testFileName = "testData.txt";
        System.out.println("Test data will be saved to: " + new File(testFileName).getAbsolutePath());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFileName, false))) {
            writer.write("TEST: This is a static test message.");
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error during test file write: " + e.getMessage());
            e.printStackTrace();
        }
        // Print the file size to see if something was written
        File file = new File(testFileName);
        System.out.println("Finished writing test data. File size: " + file.length() + " bytes");
    }
}