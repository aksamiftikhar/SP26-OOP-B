package lecture21_ExceptionHandling;

/* ============================================================================
 *  Demo 01  ·  The Call Stack: A Pre-Requisite for Exception Handling
 * ============================================================================
 *
 *  Before we can understand HOW exceptions travel, we must first see WHERE
 *  they travel -- through the call stack.
 *
 *  When main() calls levelOne(), and levelOne() calls levelTwo(), and so on,
 *  the JVM stacks all of these "active" methods on top of each other. Each
 *  method is a "frame". A frame is removed (popped) only when its method
 *  finishes and returns control to its caller.
 *
 *  This demo deliberately builds a 4-level deep chain so you can SEE the
 *  stack grow inward and then unwind outward, in perfectly mirrored order.
 *  Once you have this picture in your head, exception propagation will
 *  feel obvious -- it is just "unwinding the stack abnormally".
 * ============================================================================ */
public class Demo01_CallStack {

    public static void main(String[] args) {
        System.out.println("[main] starts");
        levelOne();                               // main --> levelOne
        System.out.println("[main] ends");
    }

    // ── Level 1 ───────────────────────────────────────────────────────────
    public static void levelOne() {
        System.out.println("  [levelOne] starts");
        levelTwo();                               // levelOne --> levelTwo
        System.out.println("  [levelOne] ends");
    }

    // ── Level 2 ───────────────────────────────────────────────────────────
    public static void levelTwo() {
        System.out.println("    [levelTwo] starts");
        levelThree();                             // levelTwo --> levelThree
        System.out.println("    [levelTwo] ends");
    }

    // ── Level 3 ───────────────────────────────────────────────────────────
    public static void levelThree() {
        System.out.println("      [levelThree] starts");
        levelFour();                              // levelThree --> levelFour
        System.out.println("      [levelThree] ends");
    }

    // ── Level 4  (the deepest frame) ──────────────────────────────────────
    public static void levelFour() {
        System.out.println("        [levelFour] starts  <-- bottom of stack");
        int x = 5/0;
        // Notice: nothing else is called from here. The call stack is at its
        // maximum depth at this exact moment.
        System.out.println("        [levelFour] ends");
    }
}

/*  EXPECTED OUTPUT  ─────────────────────────────────────────────────────────
 *
 *      [main] starts
 *        [levelOne] starts
 *          [levelTwo] starts
 *            [levelThree] starts
 *              [levelFour] starts  <-- bottom of stack
 *              [levelFour] ends
 *            [levelThree] ends
 *          [levelTwo] ends
 *        [levelOne] ends
 *      [main] ends
 *
 *  KEY INSIGHT:
 *  Each method must wait for the methods it called to finish before it can
 *  finish itself. This wait-and-return chain is exactly what an UNCAUGHT
 *  exception will short-circuit later -- it will pop frames violently
 *  instead of letting them complete.
 *
 *  Keep this 4-level picture in mind. We will reuse it in Demo 08 to show
 *  exception propagation, and in Demo 09 when we read a stack trace.
 * ─────────────────────────────────────────────────────────────────────── */
