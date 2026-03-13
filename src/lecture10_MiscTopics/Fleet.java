package lecture10_MiscTopics;

/**
 * Fleet class — demonstrates AGGREGATION
 *
 * A Fleet "has" Cars, but does NOT own them.
 * The Cars exist independently and can belong to multiple Fleets.
 * If the Fleet is destroyed, the Cars still exist.
 *
 * Compare this with Composition (Car "has-a" Engine):
 * - In composition, the Engine is created and destroyed WITH the Car.
 * - In aggregation, the Cars exist independently of the Fleet.
 */
public class Fleet {
    private String name;
    private Car[] cars; // ← AGGREGATION: Fleet references Cars it does NOT own

    public Fleet(String name, Car[] cars) {
        this.name = name;
        this.cars = cars; // Fleet just holds references to existing Cars
    }

    public String getName() {
        return name;
    }

    public Car[] getCars() {
        return cars;
    }

    @Override
    public String toString() {
        String result = "Fleet: " + name + "\n";
        for (int i = 0; i < cars.length; i++) {
            result += "  " + (i + 1) + ". " + cars[i] + "\n";
        }
        return result;
    }
}
