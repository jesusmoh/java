package c2_linked_list;

public class LoopLinkedListDetection {

    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node head = new Node('r');
        head.next = new Node('a');
        head.next.next = new Node('a');
        head.next.next.next = new Node('a');
        head.next.next.next.next = new Node('e');
        head.next.next.next.next.next = new Node('z');
        head.next.next.next.next.next.next = head.next;

        System.out.println(isCirculaLinkedList(head));
    }

    public static boolean isCirculaLinkedList(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}