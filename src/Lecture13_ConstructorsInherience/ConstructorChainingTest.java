package Lecture13_ConstructorsInherience;

public class ConstructorChainingTest {
    public static void main(String[] args) {
//        C c = new C(1);
        B b = new B();
        b.printX();
        System.out.println(A.getCount());
        System.out.println(B.getCount()); // polymorphism
    }
}

class A
{
    protected int x;
    private static int count = 0;

    public static int getCount()
    {
        return count;
    }
    public A(int x)
    {
        System.out.println("Inside A");
        this.x = x;
    }
    public int getABC()
    {
        return 0;
    }
}
class B extends A
{
    int y;
    public int x; // this x shadows super.x

    public B(int y)
    {
        super(4);
        x = 29;
        super.x = 30;
        System.out.println("Inside B");
        this.y = y;
    }
    public B()
    {
        this(1); // super()
        System.out.println("Inside B-no-arg");
    }

    @Override
    public int getABC()
    {
        return -1;
    }

    public static int getCount()
    {
        return -1;
    }

    public void printX()
    {
        System.out.println("Inside printX");
        System.out.println(x);
        System.out.println(super.x);
    }

}
class C extends B
{
    int z;
    public C(int z)
    {
        super(10);
        System.out.println("Inside C");
        this.z = z;
    }
}
