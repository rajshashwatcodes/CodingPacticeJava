class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ZigzagLinkedList {

    public static ListNode zigzagSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        boolean flag = true; // Flag to indicate the order (true for increasing, false for decreasing)
        ListNode current = head;

        while (current.next != null) {
            if ((flag && current.val > current.next.val) || (!flag && current.val < current.next.val)) {
                // Swap values if not in order
                int temp = current.val;
                current.val = current.next.val;
                current.next.val = temp;
            }

            current = current.next;
            flag = !flag; // Toggle the order for the next pair of nodes
        }

        return head;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(9);

        System.out.println("Original Linked List:");
        printList(head);

        ListNode sortedHead = zigzagSort(head);

        System.out.println("Zigzag Sorted Linked List:");
        printList(sortedHead);
    }
}
