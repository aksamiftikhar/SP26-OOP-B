package lecture10_MiscTopics;

/**
 * StringDemo — demonstrates String immutability and related concepts
 */
public class StringDemo {

    public static void main(String[] args) {

        System.out.println("══════════════════════════════════════");
        System.out.println("   STRING IMMUTABILITY DEMO");
        System.out.println("══════════════════════════════════════\n");

        // ─── Part 1: String Pool ───────────────────────────────
        System.out.println("--- Part 1: String Pool ---");

        String city1 = "Lahore"; // goes to String Pool
        String city2 = "Lahore"; // reuses same pool entry
        String city3 = new String("Lahore"); // creates NEW object on heap

        // == checks REFERENCE (memory address), not content
        System.out.println("city1 == city2      : " + (city1 == city2)); // true (same pool object)
        System.out.println("city1 == city3      : " + (city1 == city3)); // false (different objects)

        // .equals() checks CONTENT
        System.out.println("city1.equals(city3) : " + city1.equals(city3)); // true (same content)

        System.out.println();

        // ─── Part 2: Immutability ──────────────────────────────
        System.out.println("--- Part 2: Immutability ---");

        String greeting = "Assalam o Alaikum";
        System.out.println("Original : " + greeting);

        // This does NOT modify the original String!
        // It creates a NEW String object.
        String modified = greeting.concat(", Pakistan!");
        System.out.println("After concat:");
        System.out.println("  greeting : " + greeting); // unchanged!
        System.out.println("  modified : " + modified); // new String

        // Even toUpperCase() creates a new String
        String upper = greeting.toUpperCase();
        System.out.println("  upper    : " + upper);
        System.out.println("  greeting : " + greeting); // still unchanged!

        System.out.println();

        // ─── Part 3: String Concatenation Creates New Objects ──
        System.out.println("--- Part 3: Concatenation Creates New Objects ---");

        String firstName = "Ali";
        String lastName = "Khan";
        String fullName = firstName + " " + lastName; // creates NEW String

        System.out.println("fullName: " + fullName);
        System.out.println("firstName is still: " + firstName); // unchanged

        // Each + creates a new String, which is INEFFICIENT in loops!
        String result = "";
        for (int i = 1; i <= 5; i++) {
            result = result + i + " "; // 5 new String objects created!
        }
        System.out.println("Loop result: " + result);

        System.out.println();

        // ─── Part 4: StringBuilder (Mutable Alternative) ──────
        System.out.println("--- Part 4: StringBuilder (Mutable Alternative) ---");

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            sb.append(i).append(" "); // modifies the SAME object — efficient!
        }
        System.out.println("StringBuilder result: " + sb.toString());

        // StringBuilder is useful for building large strings
        StringBuilder carInfo = new StringBuilder();
        carInfo.append("Make: Honda City\n");
        carInfo.append("Model: 2024\n");
        carInfo.append("City: Islamabad\n");
        System.out.println(carInfo);

        System.out.println();

        // ─── Part 5: Why Immutability Matters ──────────────────
        System.out.println("--- Part 5: Why Immutability Matters ---");
        System.out.println("1. SAFETY   — Strings cannot be changed by other code unexpectedly");
        System.out.println("2. POOLING  — JVM can reuse String literals (saves memory)");
        System.out.println("3. HASHING  — String's hashCode never changes (used in HashMap keys)");
        System.out.println("4. SECURITY — Passwords/URLs stored as String cannot be altered");
    }
}
