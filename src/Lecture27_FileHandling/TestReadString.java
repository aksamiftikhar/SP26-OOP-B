package Lecture27_FileHandling;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static Lecture27_FileHandling.Utils.printStudentToString;
import static Lecture27_FileHandling.Utils.Student; // static import

public class TestReadString {

    public static void main(String[] args) throws IOException {
        Path p = Path.of("students.txt");   // relative to
        // project folder

        Path p2 = Path.of("data/students.txt");

        System.out.println("Path p: " + Files.exists(p));
        System.out.println("Path p2: " + Files.exists(p2));

        System.out.println("Path p2: " + p2.toAbsolutePath());
        System.out.println("Path p2: " + p2.getFileName());

        String data = Files.readString(p2);
        System.out.println("Data: " + data);

        List<String> dataArray = Files.readAllLines(p2);
//        System.out.println("DataArray: " + dataArray.size());
////
//        System.out.println("Data: " + dataArray.get(0).split(",")[1]);
        List<Student> students = new ArrayList<>();

        // parsing student objects
        for (String line : dataArray) {
            String[] parts = line.split(",");   // split by comma
            String name = parts[0];
            int    roll   = Integer.parseInt(parts[1]);
            double gpa  = Double.parseDouble(parts[2]);
            students.add(new Student(name, roll, gpa));
        }

//        dataArray.forEach(line -> {printStudentToString(line);});


    }

}
