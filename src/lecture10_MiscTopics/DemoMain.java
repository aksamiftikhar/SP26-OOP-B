package lecture10_MiscTopics;

/**
 * DemoMain — Step-by-step test driver for all topics.
 * Run this file to see all demos in action.
 *
 * Topics Covered:
 * 1. Copy Constructor (reference copy → shallow → deep)
 * 2. Composition (Car has-a Engine)
 * 3. Aggregation (Fleet has Cars it doesn't own)
 * 4. toString() and equals() — Object class methods
 * 5. String Immutability (see also StringDemo.java for more details)
 */
public class DemoMain {

    public static void main(String[] args) {

        // ╔══════════════════════════════════════════════════╗
        // ║ DEMO 1: COPY CONSTRUCTOR ║
        // ╚══════════════════════════════════════════════════╝
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║  DEMO 1: COPY CONSTRUCTOR                       ║");
        System.out.println("╚══════════════════════════════════════════════════╝\n");

        // --- Step 1a: Reference Copy (NOT a real copy!) ---
        System.out.println("--- Step 1a: Reference Copy (= operator) ---");
        Car mehran = new Car(2015, "Suzuki Mehran", new Engine(800, "Petrol"));
        Car anotherRef = mehran; // both variables point to the SAME object!

        System.out.println("mehran     : " + mehran);
        System.out.println("anotherRef : " + anotherRef);
        System.out.println("Same object? " + (mehran == anotherRef)); // true

        // Changing one affects the other!
        anotherRef.setModel(2020);
        System.out.println("\nAfter anotherRef.setModel(2020):");
        System.out.println("mehran     : " + mehran); // also changed!
        System.out.println("anotherRef : " + anotherRef);
        System.out.println();

        // --- Step 1b: Deep Copy using Copy Constructor ---
        System.out.println("--- Step 1b: Deep Copy (Copy Constructor) ---");
        Car civic = new Car(2024, "Honda Civic", new Engine(1500, "Petrol"));
        Car civicCopy = new Car(civic); // deep copy!

        System.out.println("civic     : " + civic);
        System.out.println("civicCopy : " + civicCopy);
        System.out.println("Same object? " + (civic == civicCopy)); // false

        // Changing the copy does NOT affect the original
        civicCopy.setModel(2025);
        civicCopy.getEngine().setType("Hybrid");
        System.out.println("\nAfter modifying civicCopy:");
        System.out.println("civic     : " + civic); // unchanged!
        System.out.println("civicCopy : " + civicCopy); // changed independently

        System.out.println("\n");

        // ╔══════════════════════════════════════════════════╗
        // ║ DEMO 2: COMPOSITION (Car "has-a" Engine) ║
        // ╚══════════════════════════════════════════════════╝
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║  DEMO 2: COMPOSITION (Car has-a Engine)         ║");
        System.out.println("╚══════════════════════════════════════════════════╝\n");

        // The Engine is created INSIDE the Car — it belongs to the Car
        Car city = new Car(2023, "Honda City", new Engine(1200, "Petrol"));
        System.out.println("City car : " + city);
        System.out.println("Engine   : " + city.getEngine());

        // If we create a default Car, it automatically creates its own Engine
        Car defaultCar = new Car();
        System.out.println("\nDefault car: " + defaultCar);
        System.out.println("Its engine : " + defaultCar.getEngine());

        // KEY POINT: The Engine's life is tied to the Car
        // When the Car is destroyed (garbage collected), its Engine goes too
        System.out.println("\n>> Composition means: Engine CANNOT exist without its Car");
        System.out.println(">> The Car creates the Engine and owns it completely\n");

        System.out.println();

        // ╔══════════════════════════════════════════════════╗
        // ║ DEMO 3: AGGREGATION (Fleet "has" Cars) ║
        // ╚══════════════════════════════════════════════════╝
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║  DEMO 3: AGGREGATION (Fleet has Cars)           ║");
        System.out.println("╚══════════════════════════════════════════════════╝\n");

        // Cars exist independently BEFORE the Fleet
        Car corolla = new Car(2022, "Toyota Corolla", new Engine(1300, "Petrol"));
        Car alto = new Car(2023, "Suzuki Alto", new Engine(660, "Petrol"));
        Car yaris = new Car(2024, "Toyota Yaris", new Engine(1300, "CNG"));

        // Fleet just holds REFERENCES to these existing Cars
        Car[] carArray = { corolla, alto, yaris };

        {
            Fleet karachiFleet = new Fleet("Karachi Rent-a-Car", carArray);
            System.out.println(karachiFleet);
        }

        // KEY POINT: Cars exist independently of the Fleet
        // We can still use them even without the Fleet
        System.out.println("corolla still exists: " + corolla);

        // The same cars can belong to another Fleet too!
//        Car[] subset = { corolla, yaris };
        Fleet lahoreFleet = new Fleet("Lahore Express Cars", carArray);
        System.out.println(lahoreFleet);

        System.out.println(">> Aggregation means: Cars exist INDEPENDENTLY of Fleet");
        System.out.println(">> Fleet does not create or destroy the Cars\n");

        System.out.println();

        // ╔══════════════════════════════════════════════════╗
        // ║ DEMO 4: toString() — Object Class Method ║
        // ╚══════════════════════════════════════════════════╝
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║  DEMO 4: toString() — Object Class Method       ║");
        System.out.println("╚══════════════════════════════════════════════════╝\n");

        Car brv = new Car(2024, "Honda BR-V", new Engine(1500, "Petrol"));

        // Without toString(): would print something like
        // "lecture10_MiscTopics.Car@1a2b3c"
        // With our toString(): prints a nice readable format
        System.out.println("Printing car object directly:");
        System.out.println(brv); // calls brv.toString() automatically!
        System.out.println();

        // toString() is also called during String concatenation
        String info = "My car is: " + brv; // toString() called here too!
        System.out.println(info);

        System.out.println();

        // ╔══════════════════════════════════════════════════╗
        // ║ DEMO 5: equals() — Object Class Method ║
        // ╚══════════════════════════════════════════════════╝
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║  DEMO 5: equals() — Object Class Method         ║");
        System.out.println("╚══════════════════════════════════════════════════╝\n");

        Car car1 = new Car(2025, "Toyota Corolla", new Engine(1300, "Petrol"));
        Car car2 = new Car(2025, "Toyota Corolla", new Engine(1300, "Petrol"));
        Car car3 = car1;

        // == checks reference (are they the same object in memory?)
        System.out.println("--- Using == (reference comparison) ---");
        System.out.println("car1 == car2 : " + (car1 == car2)); // false (different objects)
        System.out.println("car1 == car3 : " + (car1 == car3)); // true (same reference)

        // .equals() checks content (are the values the same?)
        System.out.println("\n--- Using .equals() (content comparison) ---");
        System.out.println("car1.equals(car2) : " + car1.equals(car2)); // true (same values!)
        System.out.println("car1.equals(car3) : " + car1.equals(car3)); // true (same object)


        // Modify car2 and compare again
        car2.setModel(2025);
        System.out.println("\nAfter car2.setModel(2025):");
        System.out.println("car1.equals(car2) : " + car1.equals(car2)); // false now!

        System.out.println();

        // ╔══════════════════════════════════════════════════╗
        // ║ DEMO 6: Quick String Immutability Recap ║
        // ╚══════════════════════════════════════════════════╝
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║  DEMO 6: Quick String Immutability Recap        ║");
        System.out.println("╚══════════════════════════════════════════════════╝\n");

        String carName = "Corolla";
        String carName2 = "Corolla";
        String carName3 = new String("Corolla");

        System.out.println("carName == carName2        : " + (carName == carName2)); // true (String pool)
        System.out.println("carName == carName3        : " + (carName == carName3)); // false (new object)
        System.out.println("carName.equals(carName3)   : " + carName.equals(carName3)); // true (same content)

        System.out.println("\n>> For detailed String demo, run StringDemo.java");

        System.out.println("\n══════════════════════════════════════");
        System.out.println("   ALL DEMOS COMPLETE!");
        System.out.println("══════════════════════════════════════");

        String str = "abc"; // memory leak

        str = str + " hello"; // "abc hello"

    }
}
