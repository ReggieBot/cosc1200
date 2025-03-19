// COSC 1200 | In-Class Exercise 3
// Prof. Tauhid
// Reggie Brown | reggie.brown@dcmail.ca
// March 19, 2025
// Desc: Custom exception class for handling grades outside of valid range
// range = 0-100

package ICE3;

public class GradeOutOfRangeException extends Exception {
    public GradeOutOfRangeException(String message) {
        super(message);
    }
}
