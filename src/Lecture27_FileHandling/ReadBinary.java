package Lecture27_FileHandling;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import java.nio.file.*;
import java.io.*;
import java.util.*;

import static Lecture27_FileHandling.Utils.StudentSerializable;

public class ReadBinary {
    public static void main(String[] args) {
        Path path = Path.of("data/students.dat");

        try {
            ObjectInputStream ois =
                    new ObjectInputStream(Files.newInputStream(path));

            // readObject() returns Object, so we cast it back
            List<StudentSerializable> students = (List<StudentSerializable>) ois.readObject();
            ois.close();

            for (StudentSerializable s : students) {
                System.out.println(s.id + " - " + s.name);
            }

        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}
