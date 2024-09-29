package lab;

import java.util.Scanner;

public class DoubleMath {
    public static void main(String[] args) {
        String strNum1, strNum2;
        Scanner scanner = new Scanner(System.in);

        strNum1 = scanner.nextLine();
        strNum2 = scanner.nextLine();
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        System.out.println("Tong: " +(num1+num2));
        System.out.println("Hieu: " +(num1-num2));
        System.out.println("Tich: " +(num1*num2));
        System.out.println("Thuong:" +(num1/num2));
    }
}
