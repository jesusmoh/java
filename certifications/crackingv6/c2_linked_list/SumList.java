package c2_linked_list;

public class SumList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = sum / 10;
            int digit = sum % 10;

            current.next = new ListNode(digit);
            current = current.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Example usage
        // Construct linked lists representing numbers in reverse order
        ListNode l1 = new ListNode(7, new ListNode(1, new ListNode(6)));
        ListNode l2 = new ListNode(5, new ListNode(9, new ListNode(2)));

        ListNode result = addTwoNumbers(l1, l2);

        // Print the result linked list
        while (result != null) {
            System.out.print(result.val + " " + "\n");
            result = result.next;
        }
    }

}
