package Lecture27_FileHandling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import static java.nio.file.StandardOpenOption.APPEND;

//import static Lecture27_FileHandling.Utils.printStudentToString;
import static Lecture27_FileHandling.Utils.Student; // static import
import static java.nio.file.StandardOpenOption.WRITE;

public class TestWriteString {
//    public static void main(String[] args) throws IOException {
//        Path p = Path.of("data/students.txt");
//
//        try {
//            Files.writeString(p, "asim ali,1,3.5\nrana atif,2,3.8\n", APPEND);
//            System.out.println("File written to: " + p);
//        }
//        catch(IOException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//
//    }

    public static void main(String[] args)  {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ali",101, 3.0));
        students.add(new Student("Sara", 102,  3.80));
        students.add(new Student( "Ahmed", 103, 1.1));

        // Build one big string: each student on its own line
        String data = "";
        for (Student s : students) {
            data += s.toFileLine() + "\n";

        }

        Path path = Path.of("data/students.txt");
        try {
            Files.writeString(path, data);

            System.out.println("Saved " + students.size() + " students.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
