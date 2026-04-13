package lecture15_interfaces;

public class InterfaceTest {
    public static void main(String[] args) {
        Drawable d1 = new MyRectangle(2, 3);
    }
}

interface Drawable {
    String color="white"; // fields in an interface are by default public, static and final; they are constants

    void draw(); // operations: what a class can do; not how to do it?
}
interface Saveable
{
    void save(String path);
}
class Shape2 {
    private int x, y;
    public void printShape() {
        System.out.println("Shape");
    }
}
class MyRectangle extends Shape2 implements Drawable, Saveable { // implmentation/realization
    int width, height;
    public MyRectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("draw a rectangle");
    }

    @Override
    public void save(String path) {
        System.out.println("save a rectangle at " + path);
    }
}
