import java.util.PriorityQueue;

public class PriorityQueue {

    public static void main(String[] args) {
        // Creating a Priority Queue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // Adding elements to the Priority Queue
        priorityQueue.add(5);
        priorityQueue.add(9);
        priorityQueue.add(1);
        priorityQueue.add(3);

        System.out.println("Priority Queue: " + priorityQueue);

        // Removing elements from the Priority Queue
        int removedElement = priorityQueue.poll();
        System.out.println("Removed Element: " + removedElement);
        System.out.println("Updated Priority Queue: " + priorityQueue);

        // Peeking at the first element without removing it
        int peekedElement = priorityQueue.peek();
        System.out.println("Peeked Element: " + peekedElement);
        System.out.println("Priority Queue after peek: " + priorityQueue);
    }
}
