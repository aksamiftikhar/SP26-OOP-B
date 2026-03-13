package practice_arraylist;

import java.util.ArrayList;

/**
 * ============================================================
 * ARRAYLIST PRACTICE EXERCISE
 * ============================================================
 *
 * INSTRUCTIONS:
 * Complete each method below. Each method has a description
 * of what it should do. You may use ONLY the following
 * ArrayList methods (no equals-dependent methods):
 *
 * add(element) - append to end
 * add(index, element) - insert at index
 * get(index) - retrieve element at index
 * set(index, element) - replace element at index
 * remove(index) - remove element at index (by position)
 * size() - number of elements
 * isEmpty() - true if list has no elements
 * clear() - remove all elements
 *
 * You may also use:
 * - for loops (regular and enhanced/for-each)
 * - Autoboxing / auto-unboxing for wrapper types
 *
 * DO NOT use: contains(), indexOf(), remove(Object)
 * ============================================================
 */
public class ArrayListPractice {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("  PART 1: ArrayList of Primitive Types");
        System.out.println("========================================\n");

        // -----------------------------------------------
        // TASK 1: Create and populate an Integer ArrayList
        // -----------------------------------------------
        // Create an ArrayList<Integer> called 'scores' and add these exam scores:
        // 85, 92, 78, 95, 88, 73, 90, 82
        // Print the list using a for-each loop.

        // >>> YOUR CODE HERE <<<

        System.out.println("\n--- Task 1: Scores ---");
        // Print each score on a separate line using a for-each loop
        // >>> YOUR CODE HERE <<<

        // -----------------------------------------------
        // TASK 2: Access and modify elements
        // -----------------------------------------------
        // a) Print the score at index 3
        // b) Change the score at index 1 to 97
        // c) Insert score 100 at index 0 (beginning of list)
        // d) Print the updated list size
        // e) Print all scores using a regular for loop

        System.out.println("\n--- Task 2: Access & Modify ---");
        // >>> YOUR CODE HERE <<<

        // -----------------------------------------------
        // TASK 3: Remove elements by index
        // -----------------------------------------------
        // a) Remove the last element from 'scores'
        // (Hint: use size() to find the last index)
        // b) Remove the element at index 2
        // c) Print the updated list using a for-each loop

        System.out.println("\n--- Task 3: Remove by Index ---");
        // >>> YOUR CODE HERE <<<

        // -----------------------------------------------
        // TASK 4: Calculate statistics
        // -----------------------------------------------
        // Using the 'scores' ArrayList, calculate and print:
        // a) The sum of all scores
        // b) The average score (as a double)
        // c) The highest score
        // d) The lowest score

        System.out.println("\n--- Task 4: Statistics ---");
        // >>> YOUR CODE HERE <<<

        // -----------------------------------------------
        // TASK 5: Build a filtered list
        // -----------------------------------------------
        // Create a NEW ArrayList<Integer> called 'highScores'.
        // Loop through 'scores' and add only scores >= 85
        // to the 'highScores' list.
        // Print the highScores list using a for-each loop.

        System.out.println("\n--- Task 5: Filtered List ---");
        // >>> YOUR CODE HERE <<<

        // -----------------------------------------------
        // TASK 6: ArrayList of Doubles
        // -----------------------------------------------
        // Create an ArrayList<Double> called 'temperatures' with values:
        // 36.5, 37.1, 38.2, 36.8, 39.0, 37.5
        //
        // a) Print all temperatures using a for loop with index
        // b) Count how many temperatures are above 37.0 (fever)
        // c) Replace all fever temperatures (> 37.0) with 37.0
        // (use set() to update in-place)
        // d) Print the modified list

        System.out.println("\n--- Task 6: Temperatures ---");
        // >>> YOUR CODE HERE <<<

        System.out.println("\n\n========================================");
        System.out.println("  PART 2: ArrayList of Reference Types");
        System.out.println("========================================\n");

        // -----------------------------------------------
        // TASK 7: Create and populate a Book ArrayList
        // -----------------------------------------------
        // Create an ArrayList<Book> called 'library' and add 5 books:
        // "Java Programming" by "Deitel" price 2500.0
        // "Clean Code" by "Robert Martin" price 3200.0
        // "Head First Java" by "Kathy Sierra" price 1800.0
        // "Effective Java" by "Joshua Bloch" price 2900.0
        // "Data Structures" by "Mark Weiss" price 2100.0
        //
        // Print all books using a for-each loop (toString will be called automatically)

        System.out.println("--- Task 7: Library ---");
        // >>> YOUR CODE HERE <<<

        // -----------------------------------------------
        // TASK 8: Access and modify Book objects
        // -----------------------------------------------
        // a) Get the Book at index 2 and print its title using getTitle()
        // b) Change the price of the book at index 0 to 2800.0
        // (get the Book object, then call setPrice on it)
        // c) Replace the book at index 4 with a new Book:
        // "Algorithms" by "Sedgewick" price 3500.0
        // (use set() method)
        // d) Insert a new book at index 1:
        // "Design Patterns" by "Gang of Four" price 3000.0
        // (use add(index, element))
        // e) Print the updated library

        System.out.println("\n--- Task 8: Access & Modify Books ---");
        // >>> YOUR CODE HERE <<<

        // -----------------------------------------------
        // TASK 9: Search by iterating (manual search)
        // -----------------------------------------------
        // Since we are NOT using contains() or indexOf(),
        // write a loop to find a book by title.
        //
        // a) Search for the book with title "Clean Code"
        // - Loop through the list, compare titles using
        // .getTitle().equals("Clean Code")
        // (this is String's equals, not Object's equals on Book)
        // - If found, print the book details and its index
        // - If not found, print "Book not found"
        //
        // b) Search for a book with title "Python Programming"
        // (this should print "Book not found")

        System.out.println("\n--- Task 9: Manual Search ---");
        // >>> YOUR CODE HERE <<<

        // -----------------------------------------------
        // TASK 10: Remove by index after manual search
        // -----------------------------------------------
        // Remove the book titled "Head First Java" from the library:
        // - First, find its index by looping through the list
        // - Then, use remove(index) to remove it
        // - Print the updated library

        System.out.println("\n--- Task 10: Remove After Search ---");
        // >>> YOUR CODE HERE <<<

        // -----------------------------------------------
        // TASK 11: Collect books by criteria
        // -----------------------------------------------
        // Create a new ArrayList<Book> called 'affordable'.
        // Loop through 'library' and add all books with
        // price <= 2800.0 to the 'affordable' list.
        // Print the affordable books list.

        System.out.println("\n--- Task 11: Affordable Books ---");
        // >>> YOUR CODE HERE <<<

        // -----------------------------------------------
        // TASK 12: Calculate total and average price
        // -----------------------------------------------
        // a) Calculate the total price of all books in 'library'
        // b) Calculate the average price
        // c) Find the most expensive book (print its details)

        System.out.println("\n--- Task 12: Price Analysis ---");
        // >>> YOUR CODE HERE <<<

        System.out.println("\n\n========================================");
        System.out.println("  PART 3: Combined / Challenge Tasks");
        System.out.println("========================================\n");

        // -----------------------------------------------
        // TASK 13: Swap elements
        // -----------------------------------------------
        // Write code to swap the first and last book in 'library'.
        // Hint: use get(), then set() to replace at each position.
        // Print the library before and after the swap.

        System.out.println("--- Task 13: Swap First and Last ---");
        // >>> YOUR CODE HERE <<<

        // -----------------------------------------------
        // TASK 14: Reverse an Integer list
        // -----------------------------------------------
        // Create an ArrayList<Integer> called 'numbers' with
        // values: 10, 20, 30, 40, 50
        //
        // Reverse the list IN-PLACE (do not create a new list).
        // Hint: use a loop that swaps elements from both ends
        // towards the center using get() and set().
        // Print the list before and after reversing.

        System.out.println("\n--- Task 14: Reverse In-Place ---");
        // >>> YOUR CODE HERE <<<

        // -----------------------------------------------
        // TASK 15: Merge two sorted Integer lists
        // -----------------------------------------------
        // Given two SORTED ArrayList<Integer>:
        // listA: 10, 30, 50, 70
        // listB: 20, 40, 60, 80
        //
        // Create a NEW sorted ArrayList<Integer> called 'merged'
        // that contains all elements from both lists in sorted order.
        // Hint: Use two index variables (one for each list) and
        // compare elements, adding the smaller one first.
        // Print the merged list.

        System.out.println("\n--- Task 15: Merge Sorted Lists ---");
        // >>> YOUR CODE HERE <<<

        // -----------------------------------------------
        // TASK 16: Remove duplicates from Integer list
        // -----------------------------------------------
        // Create an ArrayList<Integer> called 'withDuplicates':
        // 5, 3, 8, 3, 5, 9, 1, 8, 5, 3
        //
        // Create a NEW ArrayList<Integer> called 'unique'.
        // Loop through 'withDuplicates'. For each element,
        // check (by looping through 'unique') if it already
        // exists in 'unique'. If not, add it.
        //
        // Print 'unique'. Expected: [5, 3, 8, 9, 1]

        System.out.println("\n--- Task 16: Remove Duplicates ---");
        // >>> YOUR CODE HERE <<<

        System.out.println("\n========================================");
        System.out.println("  ALL TASKS COMPLETE!");
        System.out.println("========================================");
    }
}
