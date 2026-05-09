package lecture21_ExceptionHandling;

/* ============================================================================
 *  Demo 03  ·  Basic try / catch -- the same crashes, gracefully handled
 * ============================================================================
 *
 *  In Demo 02, every problem killed the program. Here, we wrap the same
 *  five risky operations in try/catch blocks. The result is night-and-day:
 *  the user sees a clean message, the program keeps running, and we can
 *  even RETRY or fall back to a default value.
 *
 *  WHAT TO NOTICE WHILE THIS RUNS:
 *  Even though the FIRST operation throws (the array-index one), the
 *  second, third, fourth, and fifth still run. That is the entire point
 *  of exception handling -- one failure does not poison everything.
 * ============================================================================ */
public class Demo03_BasicTryCatch {

    public static void main(String[] args) {
        System.out.println("=== Running 5 risky operations safely ===\n");

        safeArrayAccess();
        safeNullAccess();
        safeDivision();
        safeParsing();
        safeDowncast();

        System.out.println("\n=== All 5 done. Program ended cleanly. ===");
    }

    // 1 ── ArrayIndexOutOfBoundsException, handled ────────────────────────
    public static void safeArrayAccess() {
        int[] grades = { 85, 72, 91 };
        try {
            System.out.println("Trying to read grades[5]...");
            int g = grades[5];                     // will throw
            System.out.println("Value: " + g);     // SKIPPED if throw happens
        } catch (ArrayIndexOutOfBoundsException ex) {
            // We are now in control. Instead of crashing, we tell the user
            // and move on. The exception object 'ex' carries information
            // about what went wrong.
            System.out.println("  -> Sorry, that grade slot does not exist.");
        }
    }

    // 2 ── NullPointerException, handled ──────────────────────────────────
    public static void safeNullAccess() {
        String name = null;
        try {
            System.out.println("Trying to read length of a null name...");
            System.out.println("Length: " + name.length());
        } catch (NullPointerException ex) {
            // A defensive fallback -- we substitute a safe default.
            System.out.println("  -> Name was missing. Using 'Anonymous'.");
        }
    }

    // 3 ── ArithmeticException, handled ───────────────────────────────────
    public static void safeDivision() {
        int total = 100;
        int count = 0;
        try {
            System.out.println("Trying to compute average of zero items...");
            int avg = total / count;               // will throw
            System.out.println("Average: " + avg);
        } catch (ArithmeticException ex) {
            System.out.println("  -> No items to average. Reporting 0.");
        }
    }

    // 4 ── NumberFormatException, handled ─────────────────────────────────
    public static void safeParsing() {
        String userInput = "twenty";
        try {
            System.out.println("Trying to parse '" + userInput + "' as int...");
            int n = Integer.parseInt(userInput);
            System.out.println("Parsed: " + n);
        } catch (NumberFormatException ex) {
            // In a real app we would re-prompt the user. For the demo we
            // simply log and continue.
            System.out.println("  -> '" + userInput + "' is not a number. Please try again.");
        }
    }

    // 5 ── ClassCastException, handled ────────────────────────────────────
    public static void safeDowncast() {
        Object obj = "I am a String";
        try {
            System.out.println("Trying to cast a String to Integer...");
            Integer n = (Integer) obj;
            System.out.println("Got: " + n);
        } catch (ClassCastException ex) {
            // In well-written code we would have used 'instanceof' (Ch 10)
            // BEFORE the cast to avoid the throw entirely. This catch is
            // here as a safety net.
            System.out.println("  -> That object is not an Integer.");
        }
    }
}

/*  EXPECTED OUTPUT (abridged) ───────────────────────────────────────────────
 *
 *      === Running 5 risky operations safely ===
 *
 *      Trying to read grades[5]...
 *        -> Sorry, that grade slot does not exist.
 *      Trying to read length of a null name...
 *        -> Name was missing. Using 'Anonymous'.
 *      Trying to compute average of zero items...
 *        -> No items to average. Reporting 0.
 *      Trying to parse 'twenty' as int...
 *        -> 'twenty' is not a number. Please try again.
 *      Trying to cast a String to Integer...
 *        -> That object is not an Integer.
 *
 *      === All 5 done. Program ended cleanly. ===
 *
 *  KEY TAKEAWAYS:
 *   1. The 'try' block contains the code that MIGHT throw.
 *   2. The 'catch' block contains our REACTION to the throw.
 *   3. After a catch finishes, execution continues normally with whatever
 *      code follows the try-catch -- not from where the throw happened.
 * ─────────────────────────────────────────────────────────────────────── */
