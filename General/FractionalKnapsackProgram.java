import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsackProgram {

    static class Item {
        int weight;
        int value;
        double valuePerWeight;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.valuePerWeight = (double) value / weight;
        }
    }

    public static double getMaxValue(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(weights[i], values[i]);
        }

        // Sort items by value per weight in descending order
        Arrays.sort(items, Comparator.comparingDouble(a -> -a.valuePerWeight));

        double totalValue = 0;
        int remainingCapacity = capacity;

        for (Item item : items) {
            if (remainingCapacity >= item.weight) {
                totalValue += item.value;
                remainingCapacity -= item.weight;
            } else {
                totalValue += remainingCapacity * item.valuePerWeight;
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;

        double maxValue = getMaxValue(weights, values, capacity);
        System.out.println("Maximum value that can be obtained: " + maxValue);
    }
}
