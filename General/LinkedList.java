class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedList {

    public static ListNode insert(ListNode head, int data) {
        ListNode newNode = new ListNode(data);

        if (head == null) {
            return newNode;
        }

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        return head;
    }

    public static ListNode delete(ListNode head, int data) {
        if (head == null) {
            return null;
        }

        if (head.val == data) {
            return head.next;
        }

        ListNode current = head;
        while (current.next != null && current.next.val != data) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }

        return head;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = null;

        head = insert(head, 1);
        head = insert(head, 2);
        head = insert(head, 3);
        head = insert(head, 4);

        System.out.println("Original Linked List:");
        printList(head);

        head = delete(head, 3);
        System.out.println("Linked List after deleting 3:");
        printList(head);

        head = insert(head, 5);
        System.out.println("Linked List after inserting 5:");
        printList(head);
    }
}
