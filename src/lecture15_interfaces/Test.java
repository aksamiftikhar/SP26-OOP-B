package lecture15_interfaces;
abstract class Shape {
    abstract double area();
    public void draw() {

    }

    public void draw(int a) {

    }
}
 class Square extends Shape {
    int side = 4;
    double area() { return side * side; }
    final void printSquare()
    {
        System.out.println("Inside Square with side  " + side);
    }
    public void draw()
    {
        System.out.println("Drawing InsideSquare  with side  " + side);
    }
}
//class SquareExt extends String {
//    @Override
//    public void printSquare()
//    {
//
//    }
//}
class Rectangle extends Shape {
    int side1 = 2;
    int side2 = 3;
    double area() { return side1 * side2; }
    void printRectangle()
    {
        System.out.println("Inside Rectangle with side  " + side1 + ", " + side2);
    }
}

public class Test {
    public static void main(String[] args) {
        Shape s = new Square();

        Square sq = (Square) s;
        if(s instanceof Rectangle) {
            Rectangle r = (Rectangle) s;
            r.printRectangle();
        }
        sq.printSquare();
        System.out.println(s.area());
    }
}
