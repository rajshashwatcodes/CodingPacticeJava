public class DoublyLinkedList {
    public static void main(String[] args) {
        // Create a doubly linked list
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;
        third.next = null;

        // Traverse and print the doubly linked list
        System.out.println("Doubly Linked List:");
        printDoubly(head);
    }

    public static void printDoubly(Node head) {
        if (head == null)
            return;

        Node current = head;

        // Traverse the doubly linked list until we reach the end
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    static class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
}
