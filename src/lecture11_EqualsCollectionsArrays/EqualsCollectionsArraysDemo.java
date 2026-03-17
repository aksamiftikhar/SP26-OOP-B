package lecture11_EqualsCollectionsArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Lecture 11 demo:
 * Shows where equals() is used and where ordering (compareTo) is used.
 */
public class EqualsCollectionsArraysDemo {

    public static void main(String[] args) {
//        BookNoEquals bne = new BookNoEquals("abc", "c");
//        System.out.println(bne.equals(new BookNoEquals("abc", "c"))); // false
//        System.out.println(bne.equals(bne)); // true
//
//        BookWithEquals bwe1 = new BookWithEquals("abc", "c");
//        BookWithEquals bwe2 = new BookWithEquals("abc", "c1");

//        bwe1.equals(bwe1); // true
//        Object obj = new Object();
//        bwe2.equals(bne);

//        System.out.println(bwe1.equals(bwe2));

//        System.out.println("my string"=="my string");           // true: comparing references
//        System.out.println("my string".equals("my string"));    // true: comparing contents
//
//        System.out.println(new String("my string") == (new String("my string"))); // false: compares references
//        System.out.println(new String("my string").equals(new String("my string"))); // true: compares contents
//
        demoArrayListWithoutEquals();
        demoArrayListWithEquals();
//        demoArraysEquals();
    }

    private static void demoArrayListWithoutEquals() {
        System.out.println("==============================================");
        System.out.println("1) ArrayList methods WITHOUT overriding equals");
        System.out.println("==============================================");

        ArrayList<BookNoEquals> list = new ArrayList<BookNoEquals>();
        BookNoEquals probe = new BookNoEquals("Clean Code", "Robert Martin");

//        list.add(probe);
        list.add(new BookNoEquals("Clean Code", "Robert Martin"));
        list.add(new BookNoEquals("Effective Java", "Joshua Bloch"));


        System.out.println("List: " + list);
        System.out.println("Probe object: " + probe);
        System.out.println("list.contains(probe): " + list.contains(probe));
//        System.out.println("list.indexOf(probe): " + list.indexOf(probe));
//        System.out.println("list.remove(probe): " + list.remove(probe));
//        System.out.println("Reason: default equals compares references (same memory object).\n");
    }

    private static void demoArrayListWithEquals() {
        System.out.println("===========================================");
        System.out.println("2) ArrayList methods WITH overriding equals");
        System.out.println("===========================================");

        ArrayList<BookWithEquals> list = new ArrayList<BookWithEquals>();
        list.add(new BookWithEquals("Clean Code", "Robert Martin"));
        list.add(new BookWithEquals("Effective Java", "Joshua Bloch"));


        BookWithEquals probe = new BookWithEquals("Clean Code", "Robert Martin");

        System.out.println("List: " + list);
        System.out.println("Probe object: " + probe);
        System.out.println("list.contains(probe): " + list.contains(probe));
        System.out.println("list.indexOf(probe): " + list.indexOf(probe));
        System.out.println("list.remove(probe): " + list.remove(probe));
        System.out.println("List after remove: " + list);
        System.out.println("Reason: methods call equals() to check logical equality.\n");
    }

    private static void demoArraysEquals() {
        System.out.println("=====================================");
        System.out.println("3) Arrays.equals on object arrays");
        System.out.println("=====================================");

        BookNoEquals[] a1 = {
                new BookNoEquals("Java", "Deitel"),
                new BookNoEquals("OOP", "Author X")
        };
        BookNoEquals[] a2 = {
                new BookNoEquals("Java", "Deitel"),
                new BookNoEquals("OOP", "Author X")
        };

        BookWithEquals[] b1 = {
                new BookWithEquals("Java", "Deitel"),
                new BookWithEquals("OOP", "Author X")
        };
        BookWithEquals[] b2 = {
                new BookWithEquals("Java", "Deitel"),
                new BookWithEquals("OOP", "Author X")
        };
        System.arraycopy(a1, 0, a2, 0, a1.length);

        System.out.println("Arrays.equals(a1, a2): " + Arrays.equals(a1, a2));
        System.out.println("Arrays.equals(b1, b2): " + Arrays.equals(b1, b2));
        System.out.println("Arrays.equals uses equals() on each element.\n");


    }

}

class BookNoEquals {
    private String title;
    private String author;

    public BookNoEquals(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookNoEquals{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

class BookWithEquals {
    private String title;
    private String author;

    public BookWithEquals(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        // instanceof operator: checks the type of a reference variable
        if (!(obj instanceof BookWithEquals)) {
            return false;
        }

        BookWithEquals other = (BookWithEquals) obj; // type-casting / type-conversion
        return this.title.equals(other.title) ;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + author.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "BookWithEquals{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}


