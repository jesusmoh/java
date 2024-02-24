
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueDequeExample {
    public static void main(String[] args) {
        // Queue example
        Queue<String> queue = new LinkedList<>();

        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");

        System.out.println("Queue elements: " + queue);

        System.out.println("Polling from the queue: " + queue.poll());
        System.out.println("Queue after polling: " + queue);

        // Deque example
        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(1);
        deque.addLast(2);
        deque.addLast(3);

        System.out.println("Deque elements: " + deque);

        System.out.println("Removing first element from deque: " + deque.removeFirst());
        System.out.println("Deque after removal: " + deque);
    }
}