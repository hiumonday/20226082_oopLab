package hust.soict.dsai.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "src/hust/soict/dsai/garbage/10mb-examplefile-com.txt"; // Path to a large file
        byte[] inputBytes = {0};
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));

            startTime = System.currentTimeMillis();

            StringBuffer outputStringBuffer = new StringBuffer();
            for (byte b : inputBytes) {
                outputStringBuffer.append((char) b);
            }

            endTime = System.currentTimeMillis();

            System.out.println("Time taken with StringBuffer: " + (endTime - startTime) + " ms");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
