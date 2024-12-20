package hust.soict.dsai.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "src/10mb-examplefile-com.txt";
        byte[] inputBytes = {0};
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));

            startTime = System.currentTimeMillis();

            String outputString = "";
            for (byte b : inputBytes) {
                outputString += (char) b; // Creates a new String object on each iteration
            }

            endTime = System.currentTimeMillis();

            System.out.println("Time taken with + operator: " + (endTime - startTime) + " ms");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
