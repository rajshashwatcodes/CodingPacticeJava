import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Item {
    String name;
    double weight;
    double value;

    public Item(String name, double weight, double value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }
}

public class FractionalKnapsack {
    public static List<Item> knapsack(List<Item> items, double capacity) {
        items.sort(Comparator.comparingDouble(item -> -item.value / item.weight));
        List<Item> knapsack = new ArrayList<>();
        double currentWeight = 0;
        double totalValue = 0;

        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                knapsack.add(item);
                currentWeight += item.weight;
                totalValue += item.value;
            } else {
                double remainingCapacity = capacity - currentWeight;
                double fraction = remainingCapacity / item.weight;
                knapsack.add(new Item(item.name, remainingCapacity, item.value * fraction));
                totalValue += item.value * fraction;
                break;
            }
        }

        return knapsack;
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item1", 10, 60));
        items.add(new Item("Item2", 20, 100));
        items.add(new Item("Item3", 30, 120));

        double capacity = 50;

        List<Item> selectedItems = knapsack(items, capacity);

        System.out.println("Selected Items:");
        for (Item item : selectedItems) {
            System.out.println(item.name + " - Weight: " + item.weight + ", Value: " + item.value);
        }

        double totalValue = selectedItems.stream().mapToDouble(item -> item.value).sum();
        System.out.println("Total Value: " + totalValue);
    }
}
