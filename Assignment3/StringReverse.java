package Assignment3;

// This class is used to demonstrate recursion
// It uses a method to reverse a string

// ---- References ----
// https://www.w3schools.com/java/ref_string_substring.asp
// https://www.w3schools.com/java/ref_string_charat.asp
// https://www.geeksforgeeks.org/reverse-a-string-using-recursion/

public class StringReverse {
    
    public static String stringReverse(String str) {

        // Defining base cases and terminating conditions
        // If sring is empty || string has only one char
        if (str.length() == 0 || str.length() == 1) {
            return str;
        }

        // Recursion
        // Takes first character of string and puts it at the end
        // Then calls the method again with the substring starting from the second character

        return stringReverse(str.substring(1)) + str.charAt(0);
    }
}
