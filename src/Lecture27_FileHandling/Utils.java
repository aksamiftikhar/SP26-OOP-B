package Lecture27_FileHandling;

import java.io.Serializable;

public class Utils {
    public static void printStudentToString(String studentData)
    {
        String[] details = studentData.split(",");

        String name = details[0];
        int roll = Integer.parseInt(details[1]);
        double gpa = Double.parseDouble(details[2]);

        Student stdObj = new Student(name, roll, gpa);
        System.out.println(stdObj);
    }

    static class StudentSerializable implements Serializable {
        int id;
        String name;
        double gpa;

        StudentSerializable(int id, String name, double gpa) {
            this.id = id;
            this.name = name;
            this.gpa = gpa;
        }
    }

    static class Student
    {
        String name;
        int roll;
        double gpa;
        public Student(String name, int roll, double gpa)
        {
            this.name = name;
            this.roll = roll;
            this.gpa = gpa;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRoll() {
            return roll;
        }

        public void setRoll(int roll) {
            this.roll = roll;
        }

        public double getGpa() {
            return gpa;
        }

        public void setGpa(double gpa) {
            this.gpa = gpa;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Roll: " + roll + ", GPA: " + gpa;
        }

        public String toFileLine() {
            return name + "," + roll + "," + gpa;
        }
    }

}
