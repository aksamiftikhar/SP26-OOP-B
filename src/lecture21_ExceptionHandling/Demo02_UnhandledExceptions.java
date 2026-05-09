package lecture21_ExceptionHandling;

/* ============================================================================
 *  Demo 02  ·  Common Exceptions WITHOUT Handling
 *              -- the motivation for everything that follows
 * ============================================================================
 *
 *  You have already met these five exceptions in earlier work. They are the
 *  reasons your programs have crashed in the past. This demo collects them
 *  in one place so you can see EXACTLY:
 *      (a) what triggers each one,
 *      (b) what the resulting stack trace looks like,
 *      (c) and -- most importantly -- why ignoring them is unacceptable
 *          in real software.
 *
 *  HOW TO USE IN CLASS:
 *  Inside main(), only ONE of the five method calls is active at a time.
 *  After observing one crash, comment that line out and uncomment the next.
 *  (We must do them one at a time because the very first uncaught exception
 *  will terminate the JVM -- nothing after it will run.)
 * ============================================================================ */
public class Demo02_UnhandledExceptions {

    public static void main(String[] args) {
        // Run ONE at a time. Comment/uncomment as we proceed in lecture.
//            crashWithArrayIndex();
//            crashWithNullPointer();
//             crashWithArithmetic();
//             crashWithNumberFormat();
             crashWithClassCast();

    }

    // 1 ── ArrayIndexOutOfBoundsException ─────────────────────────────────
    //   Triggered when we ask for an array slot that does not exist.
    //   Real-world cause: an off-by-one in a loop, or an index that no
    //   longer matches an array that turned out smaller than expected.
    public static void crashWithArrayIndex() {
        int[] grades = { 85, 72, 91 };            // valid indices: 0, 1, 2
        System.out.println(grades[5]);             // index 5 does not exist!
    }

    // 2 ── NullPointerException ───────────────────────────────────────────
    //   Triggered when we call a method (or read a field) through a
    //   reference that does not point to any object.
    //   Real-world cause: forgetting to initialise a field, or a method
    //   returning null when we assumed it never would.
    public static void crashWithNullPointer() {
        String name = null;
        System.out.println(name.length());         // calling a method on null
    }

    // 3 ── ArithmeticException ────────────────────────────────────────────
    //   Triggered (for INTEGER division only) when the divisor is zero.
    //   NOTE: floating-point division does NOT throw -- it produces
    //   Infinity or NaN instead. So the trigger here is specifically int / 0.
    //   Real-world cause: computing an average from an empty list, or a
    //   rate where the denominator turned out to be zero.
    public static void crashWithArithmetic() {
        int total = 100;
        int count = 0;
        int avg = total / count;                   // 100 / 0  -- not allowed for int
        System.out.println(avg);
    }

    // 4 ── NumberFormatException ──────────────────────────────────────────
    //   Triggered when we ask Java to parse a string that does not look
    //   like a valid number.
    //   Real-world cause: user types "twenty" into a field that expects a
    //   number, or a CSV file contains a malformed record.
    public static void crashWithNumberFormat() {
        String userInput = "twenty";
        int n = Integer.parseInt(userInput);       // "twenty" is not a number
        System.out.println(n);
    }

    // 5 ── ClassCastException ─────────────────────────────────────────────
    //   Triggered when a downcast does not match the actual runtime type
    //   of the object. (Recall the polymorphism / instanceof discussion
    //   from Chapter 10 -- this is exactly the failure mode we avoided
    //   there by using instanceof.)
    public static void crashWithClassCast() {
        Object obj = "I am a String";              // actual type: String
        Integer n = (Integer) obj;                 // pretending it is Integer
        System.out.println(n);
    }
}

/*  THE LESSON  ──────────────────────────────────────────────────────────────
 *
 *  In every one of these cases, the program died abruptly. Any work done
 *  before the crash is lost; any cleanup that should have followed was
 *  skipped; the user sees only an ugly stack trace.
 *
 *  Real software simply cannot behave this way. A banking app that crashes
 *  because the user typed "twenty" instead of "20" is unacceptable. A
 *  navigation app that quits because it briefly saw a null reading from a
 *  GPS sensor is unacceptable. We need a controlled way to DETECT a problem,
 *  RESPOND to it, and CONTINUE running -- which is exactly what exception
 *  handling provides. That is the rest of the lecture.
 * ─────────────────────────────────────────────────────────────────────── */
