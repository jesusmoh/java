package c2_linked_list;

import java.util.LinkedList;

public class PartitionLinkedList {
    public static LinkedList<Integer> partition(LinkedList<Integer> list, int x) {
        LinkedList<Integer> lessThanX = new LinkedList<>();
        LinkedList<Integer> greaterThanOrEqualX = new LinkedList<>();

        for (Integer value : list) {
            if (value < x) {
                lessThanX.add(value);
            } else {
                greaterThanOrEqualX.add(value);
            }
        }

        lessThanX.addAll(greaterThanOrEqualX);
        return lessThanX;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(5);
        list.add(8);
        list.add(2);
        list.add(10);
        list.add(1);

        System.out.println("Original LinkedList: " + list);

        int x = 5;

        LinkedList<Integer> partitionedList = partition(list, x);

        System.out.println("Partitioned LinkedList around " + x + ": " + partitionedList);
    }
}
