package lecture09_ArrayList.practice_arraylist;

import java.util.ArrayList;

/**
 * ============================================================
 * SOLUTION KEY — INSTRUCTOR REFERENCE ONLY
 * ============================================================
 */
public class ArrayListPracticeSolution {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("  PART 1: ArrayList of Primitive Types");
        System.out.println("========================================\n");

        // --- TASK 1 ---
        ArrayList<Integer> scores = new ArrayList<Integer>();
        scores.add(85);
        scores.add(92);
        scores.add(78);
        scores.add(95);
        scores.add(88);
        scores.add(73);
        scores.add(90);
        scores.add(82);

        System.out.println("--- Task 1: Scores ---");
        for (int s : scores) {
            System.out.println(s);
        }

        // --- TASK 2 ---
        System.out.println("\n--- Task 2: Access & Modify ---");
        // a)
        System.out.println("Score at index 3: " + scores.get(3));
        // b)
        scores.set(1, 97);
        // c)
        scores.add(0, 100);
        // d)
        System.out.println("Updated size: " + scores.size());
        // e)
        for (int i = 0; i < scores.size(); i++) {
            System.out.println("Index " + i + ": " + scores.get(i));
        }

        // --- TASK 3 ---
        System.out.println("\n--- Task 3: Remove by Index ---");
        // a) remove last
        scores.remove(scores.size() - 1);
        // b) remove at index 2
        scores.remove(2);
        // c) print
        for (int s : scores) {
            System.out.println(s);
        }

        // --- TASK 4 ---
        System.out.println("\n--- Task 4: Statistics ---");
        int sum = 0;
        int highest = scores.get(0);
        int lowest = scores.get(0);
        for (int i = 0; i < scores.size(); i++) {
            int val = scores.get(i);
            sum += val;
            if (val > highest)
                highest = val;
            if (val < lowest)
                lowest = val;
        }
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + (double) sum / scores.size());
        System.out.println("Highest: " + highest);
        System.out.println("Lowest: " + lowest);

        // --- TASK 5 ---
        System.out.println("\n--- Task 5: Filtered List ---");
        ArrayList<Integer> highScores = new ArrayList<Integer>();
        for (int s : scores) {
            if (s >= 85) {
                highScores.add(s);
            }
        }
        for (int s : highScores) {
            System.out.println(s);
        }

        // --- TASK 6 ---
        System.out.println("\n--- Task 6: Temperatures ---");
        ArrayList<Double> temperatures = new ArrayList<Double>();
        temperatures.add(36.5);
        temperatures.add(37.1);
        temperatures.add(38.2);
        temperatures.add(36.8);
        temperatures.add(39.0);
        temperatures.add(37.5);

        // a) print with index
        for (int i = 0; i < temperatures.size(); i++) {
            System.out.println("Index " + i + ": " + temperatures.get(i));
        }
        // b) count fevers
        int feverCount = 0;
        for (double temp : temperatures) {
            if (temp > 37.0)
                feverCount++;
        }
        System.out.println("Fever readings: " + feverCount);
        // c) replace fevers with 37.0
        for (int i = 0; i < temperatures.size(); i++) {
            if (temperatures.get(i) > 37.0) {
                temperatures.set(i, 37.0);
            }
        }
        // d) print modified
        System.out.println("After treatment:");
        for (double temp : temperatures) {
            System.out.println(temp);
        }

        System.out.println("\n\n========================================");
        System.out.println("  PART 2: ArrayList of Reference Types");
        System.out.println("========================================\n");

        // --- TASK 7 ---
        System.out.println("--- Task 7: Library ---");
        ArrayList<Book> library = new ArrayList<Book>();

        library.add(new Book("Java Programming", "Deitel", 2500.0));
        library.add(new Book("Clean Code", "Robert Martin", 3200.0));
        library.add(new Book("Head First Java", "Kathy Sierra", 1800.0));
        library.add(new Book("Effective Java", "Joshua Bloch", 2900.0));
        library.add(new Book("Data Structures", "Mark Weiss", 2100.0));

        for (Book b : library) {
            System.out.println(b);
        }

        // --- TASK 8 ---
        System.out.println("\n--- Task 8: Access & Modify Books ---");
        // a)
        System.out.println("Book at index 2: " + library.get(2).getTitle());
        // b)
        library.get(0).setPrice(2800.0);
        // c)
        library.set(4, new Book("Algorithms", "Sedgewick", 3500.0));
        // d)
        library.add(1, new Book("Design Patterns", "Gang of Four", 3000.0));
        // e)
        for (Book b : library) {
            System.out.println(b);
        }

        // --- TASK 9 ---
        System.out.println("\n--- Task 9: Manual Search ---");
        // a) Search for "Clean Code"
        boolean found = false;
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getTitle().equals("Clean Code")) {
                System.out.println("Found at index " + i + ": " + library.get(i));
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found");
        }
        // b) Search for "Python Programming"
        found = false;
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getTitle().equals("Python Programming")) {
                System.out.println("Found at index " + i + ": " + library.get(i));
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found");
        }

        // --- TASK 10 ---
        System.out.println("\n--- Task 10: Remove After Search ---");
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getTitle().equals("Head First Java")) {
                library.remove(i);
                break;
            }
        }
        for (Book b : library) {
            System.out.println(b);
        }

        // --- TASK 11 ---
        System.out.println("\n--- Task 11: Affordable Books ---");
        ArrayList<Book> affordable = new ArrayList<Book>();
        for (Book b : library) {
            if (b.getPrice() <= 2800.0) {
                affordable.add(b);
            }
        }
        for (Book b : affordable) {
            System.out.println(b);
        }

        // --- TASK 12 ---
        System.out.println("\n--- Task 12: Price Analysis ---");
        double totalPrice = 0;
        Book mostExpensive = library.get(0);
        for (int i = 0; i < library.size(); i++) {
            totalPrice += library.get(i).getPrice();
            if (library.get(i).getPrice() > mostExpensive.getPrice()) {
                mostExpensive = library.get(i);
            }
        }
        System.out.println("Total price: Rs. " + totalPrice);
        System.out.println("Average price: Rs. " + totalPrice / library.size());
        System.out.println("Most expensive: " + mostExpensive);

        System.out.println("\n\n========================================");
        System.out.println("  PART 3: Combined / Challenge Tasks");
        System.out.println("========================================\n");

        // --- TASK 13 ---
        System.out.println("--- Task 13: Swap First and Last ---");
        System.out.println("Before swap:");
        for (Book b : library) {
            System.out.println(b);
        }
        Book first = library.get(0);
        Book last = library.get(library.size() - 1);
        library.set(0, last);
        library.set(library.size() - 1, first);
        System.out.println("After swap:");
        for (Book b : library) {
            System.out.println(b);
        }

        // --- TASK 14 ---
        System.out.println("\n--- Task 14: Reverse In-Place ---");
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        System.out.println("Before: ");
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();

        for (int i = 0; i < numbers.size() / 2; i++) {
            int temp = numbers.get(i);
            int j = numbers.size() - 1 - i;
            numbers.set(i, numbers.get(j));
            numbers.set(j, temp);
        }

        System.out.println("After:  ");
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();

        // --- TASK 15 ---
        System.out.println("\n--- Task 15: Merge Sorted Lists ---");
        ArrayList<Integer> listA = new ArrayList<Integer>();
        listA.add(10);
        listA.add(30);
        listA.add(50);
        listA.add(70);

        ArrayList<Integer> listB = new ArrayList<Integer>();
        listB.add(20);
        listB.add(40);
        listB.add(60);
        listB.add(80);

        ArrayList<Integer> merged = new ArrayList<Integer>();
        int a = 0, b = 0;
        while (a < listA.size() && b < listB.size()) {
            if (listA.get(a) <= listB.get(b)) {
                merged.add(listA.get(a));
                a++;
            } else {
                merged.add(listB.get(b));
                b++;
            }
        }
        while (a < listA.size()) {
            merged.add(listA.get(a));
            a++;
        }
        while (b < listB.size()) {
            merged.add(listB.get(b));
            b++;
        }
        System.out.println("Merged: ");
        for (int n : merged) {
            System.out.print(n + " ");
        }
        System.out.println();

        // --- TASK 16 ---
        System.out.println("\n--- Task 16: Remove Duplicates ---");
        ArrayList<Integer> withDuplicates = new ArrayList<Integer>();
        withDuplicates.add(5);
        withDuplicates.add(3);
        withDuplicates.add(8);
        withDuplicates.add(3);
        withDuplicates.add(5);
        withDuplicates.add(9);
        withDuplicates.add(1);
        withDuplicates.add(8);
        withDuplicates.add(5);
        withDuplicates.add(3);

        ArrayList<Integer> unique = new ArrayList<Integer>();
        for (int i = 0; i < withDuplicates.size(); i++) {
            int val = withDuplicates.get(i);
            boolean alreadyExists = false;
            for (int j = 0; j < unique.size(); j++) {
                if (unique.get(j) == val) { // works for small ints due to auto-unboxing
                    alreadyExists = true;
                    break;
                }
            }
            if (!alreadyExists) {
                unique.add(val);
            }
        }
        System.out.println("Unique: ");
        for (int n : unique) {
            System.out.print(n + " ");
        }
        System.out.println();

        System.out.println("\n========================================");
        System.out.println("  ALL TASKS COMPLETE!");
        System.out.println("========================================");
    }
}
