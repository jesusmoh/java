package c2_linked_list;

public class PalindromeLinkedList {

    public static void main(String[] args) {

        var n = new ListNode('a');
        n.next = new ListNode('d');
        n.next.next = new ListNode('g');
        n.next.next.next = new ListNode('d');
        n.next.next.next.next = new ListNode('a');

        var n1 = new ListNode('a');
        n1.next = new ListNode('d');
        n1.next.next = new ListNode('g');
        n1.next.next.next = new ListNode('d');
        n1.next.next.next.next = new ListNode('a');
        n1.next.next.next.next.next = new ListNode('u');
        n1.next.next.next.next.next.next = new ListNode('a');

        System.out.println(isPalindrome(n));

        System.out.println(isPalindrome(n1));

    }

    static class ListNode {
        char val;
        ListNode next;

        ListNode(char val) {
            this.val = val;
        }

        ListNode(char val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static boolean isPalindrome(ListNode n) {

        var record = new int[128];// ASCII
        int odd = 0;
        while (n != null) {
            record[n.val]++;
            if (n.next == null)
                n = null;
            else
                n = n.next;
        }
        for (int i = 0; i < record.length && odd <= 1; i++) {
            if (record[i] % 2 != 0)
                odd++;
        }

        return odd <= 1;
    }
}
