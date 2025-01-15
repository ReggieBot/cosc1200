package Week2Exercices;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the fibonnaci position: ");
        int position = scanner.nextInt();

        System.out.println("That position of the fibonacci sequence is = " + getFibonnaci(position));

        scanner.close();

    }

    public static int getFibonnaci(int position) {

        if (position <= 0) {
            return 0;
        }
        if (position == 1 || position == 2) {
            return 1;
        }

        int previous = 1;
        int current = 1;
        int result = 0;

        for (int i = 3; i <= position; i++) {
            result = current + previous;
            previous = current;
            current = result;
        }

        return result;
    }
}

