package lecture21_ExceptionHandling;

/* ============================================================================
 *  Demo 09  ·  Useful Throwable methods -- getMessage() and printStackTrace()
 * ============================================================================
 *
 *  Inside a catch block, the parameter is a real OBJECT. It is an instance
 *  of (a subclass of) Throwable -- so all of Throwable's methods are
 *  available to us. Two are indispensable:
 *
 *      String  getMessage()       -> the short human-readable description
 *                                    that was passed to the exception's
 *                                    constructor.
 *
 *      void    printStackTrace()  -> prints the exception's class, its
 *                                    message, and the FULL chain of method
 *                                    calls that led to the throw site.
 *                                    Output goes to System.err (not stdout).
 *
 *  Because these methods are defined in Throwable, they work on EVERY
 *  exception type -- another payoff of the inheritance hierarchy.
 *
 *  This demo deliberately throws from inside a multi-level call chain
 *  (just like Demo 08) so the stack trace is interesting to read.
 * ============================================================================ */
public class Demo09_ThrowableMethods {

    public static void main(String[] args) {
        try {
            outer();
        } catch (Exception ex) {
            // Method 1: the short message --------------------------------
            // This is what end-users would normally see in a polished UI.
            System.out.println("Message only:");
            System.out.println("    " + ex.getMessage());

            System.out.println();

            // Method 2: the full stack trace -----------------------------
            // This is what DEVELOPERS read when diagnosing a bug. Each
            // line of the trace names a method and the source line where
            // the call (or throw) happened. Read from TOP to BOTTOM:
            //   - the top line is the throw site
            //   - lower lines show who called whom, all the way to main
            // It is the runtime's confession of exactly what just went wrong.
            System.out.println("Full stack trace (printed to System.err):");
            ex.printStackTrace();

            // Note: printStackTrace() writes to System.err. In some
            // terminals this appears interleaved with System.out output.
            // That is normal -- they are independent streams.
        }
    }

    // The next three methods exist purely to make the stack trace longer
    // and therefore more illustrative. Compare the trace produced here with
    // what you saw in Demo 02 -- same idea, more frames.
    public static void outer()  { middle(); }
    public static void middle() { inner();  }
    public static void inner() {
        // We pass a deliberately useful message to the constructor. Notice
        // that 'getMessage()' will return EXACTLY this string later -- so
        // include the offending value, not just the word "error".
        throw new IllegalStateException("inventory count went negative: -3");
    }
}

/*  EXPECTED OUTPUT  ─────────────────────────────────────────────────────────
 *
 *      Message only:
 *          inventory count went negative: -3
 *
 *      Full stack trace (printed to System.err):
 *      java.lang.IllegalStateException: inventory count went negative: -3
 *          at Demo09_ThrowableMethods.inner(Demo09_ThrowableMethods.java:NN)
 *          at Demo09_ThrowableMethods.middle(Demo09_ThrowableMethods.java:NN)
 *          at Demo09_ThrowableMethods.outer(Demo09_ThrowableMethods.java:NN)
 *          at Demo09_ThrowableMethods.main(Demo09_ThrowableMethods.java:NN)
 *
 *  HOW TO READ A STACK TRACE  (an essential debugging skill):
 *   - The TOP line is your throw site -- where the exception was created.
 *   - Each line below is the method that CALLED the line above it.
 *   - The BOTTOM line is usually 'main' (or a thread's run method).
 *   - The line numbers (shown as 'NN' above) point you straight at the
 *     suspect statements in your source code.
 *
 *  RULES OF THUMB:
 *   1. Always pass a USEFUL message when constructing an exception.
 *      Bad:  throw new IllegalStateException("error");
 *      Good: throw new IllegalStateException("inventory count went negative: " + count);
 *
 *   2. When debugging, do NOT swallow exceptions silently. At the very
 *      least, log getMessage() -- you will thank yourself at 2 a.m.
 * ─────────────────────────────────────────────────────────────────────── */
