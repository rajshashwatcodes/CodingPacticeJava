class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListSearchIndex {

    public static int search(ListNode head, int target) {
        ListNode current = head;
        int index = 0;

        while (current != null) {
            if (current.val == target) {
                return index; // Found the target value at this index.
            }
            current = current.next; // Move to the next node.
            index++;
        }

        return -1; // Target value not found in the linked list.
    }

    public static void main(String[] args) {
        // Create a sample linked list: 10 -> 20 -> 30 -> 40 -> 50
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);

        int target = 30;
        int result = search(head, target);
        if (result != -1) {
            System.out.println("Found " + target + " at index " + result + " in the linked list.");
        } else {
            System.out.println(target + " not found in the linked list.");
        }
    }
}
