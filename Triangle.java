package lab;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int step = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= step; j++) {
                System.out.print("*");
            }
            step += 2;
            System.out.println();
        }
    }
}
