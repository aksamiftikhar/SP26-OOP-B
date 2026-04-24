package lecture17_interfaces_generics;

public class Test {
    public static void main(String[] args) {
        new B().doIt();
        new C().doIt();
        new B().myMethod();
        new C().myMethod();
        X.doIt2();


//        B b2 = new B();
//        System.out.println(b2 instanceof X);

//        // X x3 = new X(); // Error
        X x2 = new B();
        System.out.println(x2 instanceof B);
//        Payable p = new SalariedEmployee();
//        Markable m1 = new B();
//        Markable m2 = new C();

//        System.out.println(b2 instanceof Markable);

//        Box<String> b1 = new Box<>();

    }
}
interface X
{
    public abstract void myMethod();
    public default void doIt() {
        System.out.println("default doIt in X");
    }
    public static void doIt2()
    {
        System.out.println("default doIt2");
    }
}
interface Y {
    public default void doIt() {
        System.out.println("default doIt in Y");
    }
}
abstract class D_multiple implements X, Y {
    @Override
    public void doIt() {
        System.out.println("doIt in D multiple");
    }
}
class B implements X
{
    @Override
    public void myMethod() {
        System.out.println("myMethod in B");
    }
}
class C implements X
{
    @Override
    public void myMethod() {
        System.out.println("myMethod in C");
    }
}

// Marker interface
interface Markable
{

}


interface Powerful extends Markable, X
{
    void doMore();
}
class ABC implements Powerful
{
    @Override
    public void doMore() {

    }

    @Override
    public void myMethod() {
        System.out.println("myMethod in ABC");
    }
}