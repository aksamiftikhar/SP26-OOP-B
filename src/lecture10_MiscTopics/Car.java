package lecture10_MiscTopics;

/**
 * Car class — demonstrates:
 * 1. Copy Constructor (shallow vs deep copy)
 * 2. Composition (Car "has-a" Engine, Car owns the Engine)
 * 3. toString() override
 * 4. equals() override
 *
 * Uses Pakistani car data for relatable examples.
 */
// All classes inherit from the Object class
public class Car {
    private int model;
    private String make;
    private Engine engine; // ← COMPOSITION: Car owns this Engine

    // Default constructor
    public Car() {
        this.model = 2024;
        this.make = "Suzuki Mehran";
        this.engine = new Engine(800, "Petrol"); // Engine created WITH Car
    }

    // Parameterized constructor
    public Car(int model, String make, Engine engine) {
        this.model = model;
        this.make = make;
        this.engine = engine;
    }

    // ───────────────────────────────────────────────
    // COPY CONSTRUCTOR — SHALLOW COPY version
    // Problem: both Cars share the SAME Engine object!
    // ───────────────────────────────────────────────
//     public Car(Car other) {
//         this.model = other.model;
//         this.make = other.make;
//         this.engine = other.engine; // ← copies reference, NOT the object!
//     }

    // ───────────────────────────────────────────────
    // COPY CONSTRUCTOR — DEEP COPY version (recommended)
    // Creates a completely independent copy
    // ───────────────────────────────────────────────
    public Car(Car other) {
        this.model = other.model;
        this.make = other.make; // String is immutable — safe
        this.engine = new Engine(other.engine); // ← deep copy using Engine's copy constructor
    }

    // Getters and Setters
    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        if (model >= 1980 && model <= 2026)
            this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    // ───────────────────────────────────────────────
    // toString() — provides a readable String representation
    // Called by System.out.println(carObject)
    // ───────────────────────────────────────────────

    public String toString() {
        return make + " " + model + " [" + engine + "]";
        // Note: engine.toString() is called automatically!
    }

    // ───────────────────────────────────────────────
    // equals() — compares two Car objects by content
    // Without this, == only checks if they are the same reference
    // ───────────────────────────────────────────────
    // Every Car object is also an object of the "Object" class.
    // The object of ANY class in java is also an object of the "Object" class.

    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null || getClass() != obj.getClass())
//            return false;

        Car other = (Car) obj;

        // double x = (double) yInt;
        return this.model == other.model
                && this.make.equals(other.make)
                && this.engine.equals(other.engine); // uses Engine's equals()
    }
}
