package c2_linked_list;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDups {
    public static void main(String[] args) {
        List<String> immutableList = List.of("foo", "foo", "baz");
        LinkedList<Object> list = new LinkedList<>(immutableList);
        System.out.println(removeDups(list));
    }

    public static List<Object> removeDups(List<Object> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }
}
