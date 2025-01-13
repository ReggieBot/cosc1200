package Logic;

public class Logic {
    public static void main(String[] args) {
        int a = 7;
        int b = 8;

        // logical && operation
        if (a == 6 && b == 8) {
            System.out.println("they are both true");
        }
        else {
            System.out.println("one or both is untrue ");
        }

        // logical || operation
        if (a == 6 || b == 8) {
            System.out.println("one or both is true");
        }
        else {
            System.out.println("both are untrue");
        }
    }
}
