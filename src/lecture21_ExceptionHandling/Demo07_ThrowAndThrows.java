package lecture21_ExceptionHandling;
import java.io.File;
import java.io.FileNotFoundException;

public class Demo07_ThrowAndThrows {

    // 'throws' -> DECLARES that this method MIGHT throw a FileNotFoundException.
    //             It is a warning to the caller: "handle me or re-declare me".
    public static void checkFileExistance(String filename) throws FileNotFoundException {
        File file = new File(filename);

        if (!file.exists()) {
            // 'throw' -> ACTUALLY throws (creates and launches) the exception object.

//            throw new ArithmeticException("abc");
                throw new FileNotFoundException("Sorry, file does not exist: " + filename);

        }


        System.out.println("File found: " + file.getAbsolutePath());
    }

    public static void main(String[] args) {
        // Caller MUST handle the declared exception (or also use 'throws').
        try {
            checkFileExistance("data.txt");   // change to a real file to see the success path
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found: " + ex.getMessage());
            ex.printStackTrace();
        }

        System.out.println("Program continues after handling the exception.");
    }
}