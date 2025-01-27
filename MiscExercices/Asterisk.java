package MiscExercices;
import java.util.Scanner;

public class Asterisk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many rows in the triangle? ");
        int rows = scanner.nextInt();
        for (int i = 1; i <= rows; i++) {

            for (int j = 1; j <= rows - i; j++)
                System.out.print(" ");


            for (int j = 1; j <= i; j++) {
                System.out.print("* ");

            }
            System.out.println();
        }
        scanner.close();
    }
}