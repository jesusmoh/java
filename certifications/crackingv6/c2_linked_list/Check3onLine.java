package c2_linked_list;

public class Check3onLine {

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
        System.out.println(check3onLine(head));
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

    public static boolean check3onLine(Node head) {

        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        Node p1 = head;
        Node p2 = head.next;
        Node p3 = head.next.next;

        while (p3 != null && p3.next != null) {
            if (p1.data == p2.data && p2.data == p3.data) {
                return true;
            }
            p1 = p1.next;
            p2 = p1.next;
            p3 = p2.next;
        }
        return false;
    }
}