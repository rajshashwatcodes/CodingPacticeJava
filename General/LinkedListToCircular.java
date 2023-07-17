class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListToCircular {
    public static void main(String[] args) {
        // Create a singly linked list
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = null;

        // Convert the singly linked list to circular linked list
        makeCircular(head);

        // Traverse and print the circular linked list
        System.out.println("Circular Linked List:");
        printCircular(head);
    }

    public static void makeCircular(Node head) {
        if (head == null)
            return;

        Node current = head;

        // Traverse to the end of the list
        while (current.next != null) {
            current = current.next;
        }

        // Make the last node point to the head, creating a circular linked list
        current.next = head;
    }

    public static void printCircular(Node head) {
        if (head == null)
            return;

        Node current = head;

        // Traverse the circular linked list until we reach the head node again
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
    }
}
