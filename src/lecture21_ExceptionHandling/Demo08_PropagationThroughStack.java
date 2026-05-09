package lecture21_ExceptionHandling;

/* ============================================================================
 *  Demo 08  ·  Exception PROPAGATION through the call stack
 *              -- the payoff from Demo 01
 * ============================================================================
 *
 *  Recall Demo 01: we built a 4-level deep call chain and watched the
 *  stack grow inward, then unwind outward in mirrored order. Now we will
 *  watch what happens when the deepest method THROWS instead of returning
 *  normally.
 *
 *  The rule:  when a throw happens, Java pops frames off the stack one by
 *  one, looking for a try/catch in any enclosing call. The very first
 *  matching catch wins. Every other frame on the way up is destroyed
 *  WITHOUT finishing its remaining code.
 *
 *  This is why we say the detector and the handler can be in completely
 *  different methods -- and indeed in different classes, different files,
 *  and at very different stack depths.
 * ============================================================================ */
public class Demo08_PropagationThroughStack {

    public static void main(String[] args) {
        System.out.println("[main] starts");
        levelOne();                                // matches the chain in Demo 01
        System.out.println("[main] ends -- program survived");
    }

    // ── Level 1: HANDLES the exception thrown 3 levels below ─────────────
    // This is the only frame in the chain that contains a try/catch, so
    // this is where the exception will finally come to rest.
    public static void levelOne() {
        System.out.println("  [levelOne] starts");
        try {
            levelTwo();                            // call into the deeper chain
            System.out.println("  [levelOne] *** this line is SKIPPED ***");
        } catch (RuntimeException ex) {
            // We caught it. Stack-unwinding stops here.
            System.out.println("  [levelOne] caught: " + ex.getMessage());
        }
        System.out.println("  [levelOne] ends -- recovered");
    }

    // ── Level 2: NO try/catch -- the exception just travels through ──────
    public static void levelTwo() {
        System.out.println("    [levelTwo] starts");
        levelThree();
        // The line below never runs once levelThree() throws.
        // Compare this with Demo 01, where every method's "ends" line ran.
        System.out.println("    [levelTwo] *** this line is SKIPPED ***");
    }

    // ── Level 3: also no try/catch ───────────────────────────────────────
    public static void levelThree() {
        System.out.println("      [levelThree] starts");
        levelFour();
        System.out.println("      [levelThree] *** this line is SKIPPED ***");
    }

    // ── Level 4: the SOURCE of the throw ─────────────────────────────────
    public static void levelFour() {
        System.out.println("        [levelFour] starts -- about to throw!");
        // The exception is born here. Java will now unwind the stack:
        //   levelFour -> levelThree -> levelTwo -> levelOne (caught here)
        throw new RuntimeException("boom from level 4");
        // No code can follow a throw -- it would be unreachable, and the
        // compiler would refuse it.
    }
}

/*  EXPECTED OUTPUT  ─────────────────────────────────────────────────────────
 *
 *      [main] starts
 *        [levelOne] starts
 *          [levelTwo] starts
 *            [levelThree] starts
 *              [levelFour] starts -- about to throw!
 *          [levelOne] caught: boom from level 4
 *        [levelOne] ends -- recovered
 *      [main] ends -- program survived
 *
 *  COMPARE WITH DEMO 01:
 *    In Demo 01 every "ends" line was printed -- a peaceful unwind. Here,
 *    the "ends" lines for levelTwo, levelThree, and levelFour are GONE.
 *    They were skipped because the throw destroyed those frames before
 *    they could finish. Only the frame that caught the exception (level 1)
 *    plus the one above it (main) survive normally.
 *
 *  WHY THIS IS POWERFUL:
 *   - The DETECTOR (level 4) does not need to know who will handle the
 *     problem. It just throws.
 *   - The HANDLER (level 1) does not need to know exactly where the problem
 *     came from. It just catches.
 *   - All the methods in between are blissfully unaware. They were not
 *     written with this particular failure in mind, and they do not have
 *     to be. Exception handling cleanly separates these concerns.
 * ─────────────────────────────────────────────────────────────────────── */
