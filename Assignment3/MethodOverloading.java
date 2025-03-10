package Assignment3;

// This class is used to demonstrate method overlading
// It defines two methods with the same name but different parameters (1,2) (1,2,3)
public class MethodOverloading {
    
    // Method to multiply two integers
    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    // Method to multiply three integers
    public static int multiply(int num1, int num2, int num3) {
        return num1 * num2 * num3;
    }
}
