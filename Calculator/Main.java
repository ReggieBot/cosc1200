package Calculator;


public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.print("5 + 6 = ");
        System.out.println(calculator.add(5, 6));

        System.out.print("34 - 15 = ");
        System.out.println(calculator.subtract(34, 15));

        System.out.print("4 * 6 = ");
        System.out.println(calculator.multiply(4,6));

        System.out.print("100 / 5 = ");
        System.out.println(calculator.divide(100, 5));
    }
}
