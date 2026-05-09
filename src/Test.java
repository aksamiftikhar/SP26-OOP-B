import lecture07_1d.GradeBook;
public class Test {
    public static void main(String[] args) {
        Box<String> b = new Box<>("abc");
        Box<Integer> i = new Box<>(1);

        Box<GradeBook> bg = new Box<>(new GradeBook("", new int[]{1,2}));

// Usage: maps a student name to their grade
        Pair<String, Integer> record = new Pair<>("Ali", 87);
        System.out.println(record.getFirst());   // Ali
        System.out.println(record.getSecond());  // 87

    }
}
 class Pair<A, B> {
    private A first;
    private
    B second;

    public Pair(A first, B second) { this.first = first; this.second = second; }
    public A getFirst()  { return first;  }
    public B getSecond() { return second; }
}

 class Box<T> {
    private T value;

    public Box(T value)  { this.value = value; }
    public T getValue()  { return value; }
    public void setValue(T value)  { this.value = value; }
}


