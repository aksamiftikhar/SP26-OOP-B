package lecture21_ExceptionHandling;

/* ============================================================================
 *  Demo 05  ·  The finally block -- cleanup that ALWAYS runs
 * ============================================================================
 *
 *  Some code MUST run regardless of whether the try block succeeded or
 *  threw -- typical examples are closing a file, releasing a network
 *  connection, or restoring a UI state. The 'finally' block is built for
 *  exactly this purpose.
 *
 *  Mental model:
 *      try     -- "the work I want to attempt"
 *      catch   -- "what to do if something goes wrong"
 *      finally -- "what to do on the way out, regardless"
 *
 *  This file traces the flow for two cases -- normal completion and a
 *  thrown exception -- so you can see by line numbers when each block
 *  actually executes.
 * ============================================================================ */
public class Demo05_FinallyBlock {

    public static void main(String[] args) {
        System.out.println("==== Calling demo(2) -- no exception ====");
        demo(2);

        System.out.println("\n==== Calling demo(0) -- division-by-zero throws ====");
        demo(0);

//        System.out.println("\n==== Practical example: simulated file open/close ====");
//        simulatedFileWork(true);   // success path
//        System.out.println();
//        simulatedFileWork(false);  // failure path
    }

    /* ----------------------------------------------------------------------
     *  The classic tracing example -- exactly as drawn in the lecture.
     * ---------------------------------------------------------------------- */
    public static void demo(int n) {
        System.out.println("--- demo(" + n + ") ---");
        try {
            System.out.println("A");
            int r = 10 / n;                        // throws if n == 0
            System.out.println("B  r = " + r);     // skipped when throwing
        } catch (ArithmeticException ex) {
            System.out.println("C  caught");
        } finally {
            System.out.println("D  finally");      // ALWAYS runs
        }
        System.out.println("E  after");
    }

    /* ----------------------------------------------------------------------
     *  A more realistic motivation. Imagine 'open' acquired a precious
     *  resource (a file handle, a DB connection). We MUST release it,
     *  whether or not the work in between succeeded.
     * ---------------------------------------------------------------------- */
    public static void simulatedFileWork(boolean shouldSucceed) {
        System.out.println("[opening resource...]");
        try {
            System.out.println("[doing work...]");
            if (!shouldSucceed) {
                // Simulate a runtime failure during the work.
                throw new RuntimeException("disk error");
            }
            System.out.println("[work done]");
        } catch (RuntimeException ex) {
            System.out.println("[caught: " + ex.getMessage() + "]");
        } finally {
            // This line runs no matter what -- even if no catch had matched.
            // Without 'finally', a forgotten close() in the failure branch
            // would leak the resource.
            System.out.println("[closing resource -- always runs]");
        }
    }
}

/*  EXPECTED OUTPUT  ─────────────────────────────────────────────────────────
 *
 *      ==== Calling demo(2) -- no exception ====
 *      --- demo(2) ---
 *      A
 *      B  r = 5
 *      D  finally
 *      E  after
 *
 *      ==== Calling demo(0) -- division-by-zero throws ====
 *      --- demo(0) ---
 *      A
 *      C  caught
 *      D  finally
 *      E  after
 *
 *      ==== Practical example: simulated file open/close ====
 *      [opening resource...]
 *      [doing work...]
 *      [work done]
 *      [closing resource -- always runs]
 *
 *      [opening resource...]
 *      [doing work...]
 *      [caught: disk error]
 *      [closing resource -- always runs]
 *
 *  KEY OBSERVATIONS:
 *   - In demo(2), B prints, C is skipped. In demo(0), B is skipped, C prints.
 *   - In BOTH cases, D and E print. That is the guarantee of finally.
 *   - In simulatedFileWork(false), the work failed but the resource was
 *     still released -- that is exactly why finally exists.
 * ─────────────────────────────────────────────────────────────────────── */
