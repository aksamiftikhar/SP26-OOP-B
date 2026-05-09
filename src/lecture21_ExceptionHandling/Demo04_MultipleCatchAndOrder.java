package lecture21_ExceptionHandling;

/* ============================================================================
 *  Demo 04  ·  Multiple catch blocks, Polymorphic catch, and Order Matters
 * ============================================================================
 *
 *  A single try block often contains code that can fail in several DIFFERENT
 *  ways -- bad input, division by zero, etc. We attach as many catch blocks
 *  as we need, one per exception type we want to react to differently.
 *
 *  This demo also shows two more important rules:
 *
 *    (a) POLYMORPHIC CATCH: a catch block matches its declared type AND any
 *        subclass of that type -- exactly the substitution principle from
 *        Chapter 10. So 'catch (RuntimeException e)' catches Null, Arithmetic,
 *        NumberFormat, ClassCast, etc., all in one place.
 *
 *    (b) ORDER MATTERS: catches are tested top-to-bottom. If a more general
 *        type appears BEFORE a more specific one, the specific catch becomes
 *        unreachable -- and the compiler refuses to compile the file.
 * ============================================================================ */
public class Demo04_MultipleCatchAndOrder {

    public static void main(String[] args) {

        // ------------------------------------------------------------------
        //  Part 1  --  Multiple catches, each handling a different problem
        // ------------------------------------------------------------------
        // The try below can fail in TWO different ways. We give each its
        // own catch with its own message, so the user sees a precise reason.
        String[] inputs = { "5", "0", "hello" };

        for (String s : inputs) {
            System.out.print("Input \"" + s + "\" -> ");
            try {
                int n = Integer.parseInt(s);       // → NumberFormatException possible
                int q = 100 / n;                    // → ArithmeticException possible
                System.out.println("100 / " + n + " = " + q);
            }
            catch (NumberFormatException ex) {
                System.out.println("not a valid integer.");
            }
            catch (ArithmeticException ex) {
                System.out.println("cannot divide by zero.");
            }
        }

        // ------------------------------------------------------------------
        //  Part 2  --  Polymorphic catch (one block, many subtypes)
        // ------------------------------------------------------------------
        // RuntimeException is the parent of Null, Arithmetic, NumberFormat,
        // ClassCast, and friends. Catching RuntimeException catches all of
        // them at once -- handy when the response is the same for every
        // kind of runtime bug (e.g. "log it and skip this record").
        System.out.println();
        for (String s : inputs) {
            System.out.print("Polymorphic catch on \"" + s + "\" -> ");
            try {
                int n = Integer.parseInt(s);
                int q = 100 / n;
                System.out.println("OK, q = " + q);
            }
            catch(NullPointerException npe)
            {
                System.out.println("problem (" + npe.getClass().getSimpleName() + ")");
            }
            catch (RuntimeException ex) {
                // Catches BOTH NumberFormatException and ArithmeticException.
                // ex.getClass().getSimpleName() lets us still identify which
                // one fired, even though we used a single catch.
                System.out.println("problem (" + ex.getClass().getSimpleName() + ")");
            }
            catch(Exception ex)
            {
                System.out.println("problem (" + ex.getClass().getSimpleName() + ")");
            }


        }
    }

    /* ----------------------------------------------------------------------
     *  Part 3  --  Order matters: a WRONG version (kept commented because
     *              it would cause a COMPILE ERROR if uncommented).
     * ----------------------------------------------------------------------
     *
     *  public static void wrongOrder() {
     *      try {
     *          riskyCode();
     *      }
     *      catch (Exception ex)            { ... }   // catches EVERYTHING first
     *      catch (ArithmeticException ex)  { ... }   // <-- compile error: unreachable
     *  }
     *
     *  The compiler can prove that no exception will ever reach the second
     *  catch (because the first one already handled it), so it refuses
     *  to compile the file. The fix is to write the SPECIFIC type first
     *  and the GENERAL one last:
     *
     *      catch (ArithmeticException ex)  { ... }   // specific
     *      catch (Exception ex)            { ... }   // general -- last
     *
     *  RULE OF THUMB: order catches from MOST SPECIFIC to MOST GENERAL.
     * ---------------------------------------------------------------------- */
}

/*  EXPECTED OUTPUT  ─────────────────────────────────────────────────────────
 *
 *      Input "5"     -> 100 / 5 = 20
 *      Input "0"     -> cannot divide by zero.
 *      Input "hello" -> not a valid integer.
 *
 *      Polymorphic catch on "5"     -> OK, q = 20
 *      Polymorphic catch on "0"     -> problem (ArithmeticException)
 *      Polymorphic catch on "hello" -> problem (NumberFormatException)
 *
 *  WHY BOTH STYLES EXIST:
 *   - Multiple specific catches  -> use when each error needs a DIFFERENT
 *                                   response.
 *   - One polymorphic catch      -> use when the response is THE SAME for
 *                                   every kind of failure (e.g. "log and
 *                                   skip"). It is shorter and clearer in
 *                                   that situation.
 * ─────────────────────────────────────────────────────────────────────── */
