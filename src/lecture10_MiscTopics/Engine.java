package lecture10_MiscTopics;

/**
 * Engine class — demonstrates composition (used as a part of Car)
 * Also demonstrates: copy constructor, toString(), equals()
 */
public class Engine {
    private int horsepower;
    private String type; // e.g., "Petrol", "Diesel", "Hybrid", "CNG"
    // another nested field
//    private AnotherClass anotherObject;

    // Default constructor
    public Engine() {
        this.horsepower = 1000;
        this.type = "Petrol";
    }

    // Parameterized constructor
    public Engine(int horsepower, String type) {
        this.horsepower = horsepower;
        this.type = type;
    }

    // ───────────────────────────────────────────────
    // COPY CONSTRUCTOR — creates a NEW independent copy
    // ───────────────────────────────────────────────
    public Engine(Engine other) {
        this.horsepower = other.horsepower;
        this.type = other.type; // String is immutable, so sharing is safe
//        this.anotherObject = new AnotherClass(other.anotherObject);
    }

    // Getters and Setters
    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // ───────────────────────────────────────────────
    // toString() — overrides Object.toString()
    // Called automatically when printing or concatenating
    // ───────────────────────────────────────────────
    @Override
    public String toString() {
        return type + " Engine (" + horsepower + " cc)";
    }

    // ───────────────────────────────────────────────
    // equals() — overrides Object.equals()
    // Compares actual content instead of memory address
    // ───────────────────────────────────────────────
    @Override
    public boolean equals(Object obj) {
        // Step 1: Check if same reference
        if (this == obj)
            return true;

        // Step 2: Check if obj is null or different class
        if (obj == null || getClass() != obj.getClass())
            return false;

        // Step 3: Cast and compare fields
        Engine other = (Engine) obj;
        return this.horsepower == other.horsepower
                && this.type.equals(other.type);
    }
}
