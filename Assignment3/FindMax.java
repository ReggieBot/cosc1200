package Assignment3;

// This class shows an example of taking an array as a parameter
// It then iterates through the array to find the maximum integer

public class FindMax {
    
    public static int findMax(int[] array) {
        
        // Initialize the max value to the first element of the array
        // Iterate through the array and update the max value if a larger int is found
        // Stealing this from a previous assignment we did

        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
