package lecture14_Abstract_Polymorphism;

import org.w3c.dom.css.Rect;

// an abstract class
public abstract class Shape {
    private int x, y;
    private String color;

    public Shape(int x, int y, String color) {
        this.x = x;
        this.y = y;
    }

    // abstract method
    public abstract double getArea();

    // all other methods in Shape are "concrete" methods

    public static void main(String[] args) {
        // Shape s = new Shape(1, 2, "red"); // Error: cannot create an object of an abstract class
        // s.getArea();

        Shape s = new Rectangle(1, 2, 3, 4, "red"); // upcasting: a Rectangle is a Shape
        s.setColor("blue");

        // Shape s2 = new Car(); // Error: only subclass object can be saved inside the superclass reference
//        s.getWidth();
        // s.myRectMethod(); // Error: cannot call subclass-specific methods on a superclass reference
        double area = s.getArea(); // dynamic/late binding
        System.out.println("Area: " + area);

        s = new Circle(1, 2, 5, "green");
        area = s.getArea(); // resolved at runtime, therefore it is called "late" binding
//        s.setX(10); // concrete methods are also resolved through dynamic binding
        System.out.println("Area: " + area);

        // poly: multiple, morph: forms/behavior

//        double d = s.getArea(); // Error: s not initialized

//        Rectangle r = new Rectangle(1, 2, 3, 4, "red");
//        System.out.println(r.getArea());

    }
//    public void draw() {
//        // dummy implementation
//    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

// A concrete class
class Rectangle extends Shape {
    private int width, height;
    public Rectangle(int x, int y, int width, int height, String color) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    public void myRectMethod() {
        System.out.println("Test method");
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
}

class Circle extends Shape {
    private int radius;

    public Circle(int x, int y, int radius, String color) {
        super(x, y, color);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}