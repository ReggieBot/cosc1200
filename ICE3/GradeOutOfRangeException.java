package ICE3;

// Custom exception class for handling grades outside of valid range
// range = 0-100

public class GradeOutOfRangeException extends Exception {
    public GradeOutOfRangeException(String message) {
        super(message);
    }
}
