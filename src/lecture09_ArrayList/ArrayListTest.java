package lecture09_ArrayList;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Student> alStd = new ArrayList<Student>();
        Student std = new Student();
        std.rollNumber = 123;

        alStd.add(std);
        alStd.add(new Student());

        for(int i=0;i<alStd.size();i++){
            System.out.println(alStd.get(i).rollNumber);
        }
        for(Student std1:alStd)
        {
            System.out.println(std1.rollNumber);
        }
//        Student s1 = alStd.get(0);
//        System.out.println(s1.rollNumber);
//
////        alStd.remove(s1);
//        alStd.remove(0);
//        s1 = alStd.get(0);
//        System.out.println(s1.rollNumber);
//
//        System.out.println(alStd.size());
//        alStd.clear();
//        System.out.println(alStd.size());


        ArrayList<Integer> alInt = new ArrayList<Integer>(); // java.lang
        // This constructor version is obselete, so avoid using it
        // Integer x = new Integer(30);

        Integer x1 = 30;      // use autoboxing to initialize an Integer object
        alInt.add(x1);
        alInt.add(40);  // This also uses autoboxing internally.
        alInt.add(50);
        alInt.add(60);
        System.out.println(alInt);

        Integer y = x1;         // Example of auto-unboxing
        int x2 = alInt.get(0); // This also uses auto-unboxing internally
        alInt.remove(0); // will remove first element
        System.out.println(alInt);
        alInt.remove(Integer.valueOf(60)); // will remove element with value 60
        System.out.println(alInt);

        for(int i=0;i<alInt.size();i++){
            System.out.println(alInt.get(i).toString());
        }

        ArrayList<String> alStr = new ArrayList<String>();

    }
}

class Student
{
    int rollNumber;
}

//class Integer
//{
//    private int data;
//}
//
//class Character
//{
//    private char data;
//}