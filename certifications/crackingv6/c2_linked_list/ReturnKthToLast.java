package c2_linked_list;

public class ReturnKthToLast {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode findKthToLast(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;

        // Move the fast pointer k steps ahead
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null; // List is smaller than k
            }
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2; // Find the 2nd to last element

        ListNode result = findKthToLast(head, k);

        if (result != null) {
            System.out.println("The " + k + "th to last element is: " + result.val);
        } else {
            System.out.println("List is smaller than " + k);
        }
    }
}
