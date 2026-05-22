package Lecture27_FileHandling;

import java.nio.file.*;
import java.io.*;
import java.util.*;

import static Lecture27_FileHandling.Utils.StudentSerializable;
public class WriteBinary {
    public static void main(String[] args) {
        List<StudentSerializable> students = new ArrayList<>();
        students.add(new StudentSerializable(101, "Ali",   3.45));
        students.add(new StudentSerializable(102, "Sara",  3.80));

        Path path = Path.of("data/students.dat");
        try {
            // NIO gives us the stream; ObjectOutputStream does the serialization
            ObjectOutputStream oos =
                    new ObjectOutputStream(Files.newOutputStream(path));

            oos.writeObject(students);   // writes the whole list at once
            oos.close();
            System.out.println("Saved to binary file.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }


    }
}
