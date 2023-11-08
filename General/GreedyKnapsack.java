import java.util.Arrays;
import java.util.Comparator;

class Item {
    int weight;
    int value;
    double ratio;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
        this.ratio = (double) value / weight;
    }
}

public class GreedyKnapsack {
    public static double fractionalKnapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            items[i] = new Item(weights[i], values[i]);
        }

        Arrays.sort(items, Comparator.comparingDouble(item -> -item.ratio));

        double totalValue = 0.0;
        int currentWeight = 0;

        for (int i = 0; i < n; i++) {
            if (currentWeight + items[i].weight <= capacity) {
                currentWeight += items[i].weight;
                totalValue += items[i].value;
            } else {
                int remainingCapacity = capacity - currentWeight;
                totalValue += (remainingCapacity * items[i].ratio);
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;

        double maxValue = fractionalKnapsack(weights, values, capacity);
        System.out.println("Maximum value that can be obtained: " + maxValue);
    }
}
