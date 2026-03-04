//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        boolean [] c ;
        c = new boolean [3];
        double[] fArr = {1.1, 2.2, 3.3};
        double[] fArr2 = new double[3];
//        c[0] = 1;
////        c.length = 10;  // error
//        for(int i = 0; i < c.length; i++){
//            c[i] = 1;
//        }


        for(int i = 0; i < c.length; i++){
            System.out.println(c[i]);
            c[i] = true;
        }
        for(boolean b: c)
        {
            b = true;
        }
        int arr[], c1;
//        int arr[];
//        int c1;
        arr = new int[3];

        Student[] stdArr = new Student[3];
        stdArr[0] = new Student(1, "ali");
        stdArr[1] = new Student(2, "umar");
        stdArr[2] = new Student(3, "usman");

//        Student s = new Student();
        System.out.println(stdArr[0].rollNumber);

        for(Student s: stdArr){
            System.out.println(s.name);
        }
    }
}

class Student
{
    public int rollNumber;
    public String name;

    Student(int r, String n)
    {
        rollNumber = r;
        name = n;

    }
}