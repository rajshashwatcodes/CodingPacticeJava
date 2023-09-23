class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListReversedCheck {

    public static boolean isReversed(ListNode original, ListNode reversed) {
        // Traverse both linked lists and compare the values.
        while (original != null && reversed != null) {
            if (original.val != reversed.val) {
                return false; // Not reversed.
            }
            original = original.next;
            reversed = reversed.next;
        }

        // If one of the lists still has elements, they are not the same length, so not reversed.
        return original == null && reversed == null;
    }

    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3
        ListNode original = new ListNode(1);
        original.next = new ListNode(2);
        original.next.next = new ListNode(3);

        // Create a reversed version of the linked list: 3 -> 2 -> 1
        ListNode reversed = new ListNode(3);
        reversed.next = new ListNode(2);
        reversed.next.next = new ListNode(1);

        boolean result = isReversed(original, reversed);
        System.out.println("Is the linked list reversed? " + result); // Output: true
    }
}
