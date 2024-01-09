import java.util.ArrayList;
import java.util.List;

class Car {
    private String model;
    private double distance;

    public Car(String model, double distance) {
        this.model = model;
        this.distance = distance;
    }

    public String getModel() {
        return model;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", distance=" + distance +
                '}';
    }
}

public class NearbyCars {
    public static void main(String[] args) {
        List<Car> nearbyCars = new ArrayList<>();

        // Add some cars to the list
        nearbyCars.add(new Car("Toyota", 2.5));
        nearbyCars.add(new Car("Honda", 1.8));
        nearbyCars.add(new Car("Ford", 3.2));

        // Print the nearby cars
        System.out.println("Nearby Cars:");
        for (Car car : nearbyCars) {
            System.out.println(car);
        }
    }
}
