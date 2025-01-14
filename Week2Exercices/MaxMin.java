package Week2Exercices;
import java.util.Scanner;

public class MaxMin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the first number: ");
        float first = scanner.nextFloat();
        System.out.println("Please enter the second number: ");
        float second = scanner.nextFloat();
        System.out.println("Please enter the third number: ");
        float third = scanner.nextFloat();

        float max = getMax(first, second, third);
        System.out.println("The maximum number is: " + max);
        ``
        float min = getMin(first, second, third);
        System.out.println("The minimum number is: " + min);
    }

    public static float getMax(float first, float second, float third) {

        if (first >= second && first >= third) {
            return first;

        } else if (second >= first && second >= third) {
            return second;

        } else {
            return third;
        }
    }

    public static float getMin(float first, float second, float third) {

        if (first <= second && first <= third) {
            return first;

        } else if (second <= first && second <= third) {
            return second;

        } else {
            return third;
        }
    }
}
