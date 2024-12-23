import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);

        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2); // Inefficient concatenation
        }
        long end = System.currentTimeMillis();
        System.out.println("Time taken with + operator: " + (end - start) + " ms");

        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2)); // Efficient concatenation
        }
        s = sb.toString();
        end = System.currentTimeMillis();
        System.out.println("Time taken with StringBuilder: " + (end - start) + " ms");
    }
}
