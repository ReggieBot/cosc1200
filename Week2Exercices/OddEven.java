package Week2Exercices;
import java.util.Scanner;


public class OddEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number");
        int number = scanner.nextInt();
        String result = checkEvenOdd(number);
        System.out.println(result);
        scanner.close();
    }

    public static String checkEvenOdd(int number) {
        if (number % 2 == 0) {
            return "this number is even";

        } else {
            return "this number is false";
        }
    }
}
