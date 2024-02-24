package book_c9.collection.list.arraylist;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // Creating an ArrayList of Strings
        ArrayList<String> fruits = new ArrayList<>();

        // ArrayList<int> precies = new ArrayList<>(); Collections only suports Objects
        // or Wrapper

        // Adding elements to the ArrayList
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        // Displaying the elements in the ArrayList
        System.out.println("Fruits in the ArrayList: " + fruits);

        // Accessing elements by index
        System.out.println("First fruit: " + fruits.get(0));

        // Checking if an element exists in the ArrayList
        if (fruits.contains("Banana")) {
            System.out.println("Banana is in the list.");
        }

        // Removing an element from the ArrayList
        fruits.remove("Orange");

        // Displaying the updated ArrayList
        System.out.println("Updated list of fruits: " + fruits);

        // Checking the size of the ArrayList
        System.out.println("Number of fruits in the list: " + fruits.size());

        // Iterating through the ArrayList using a for-each loop
        System.out.println("Fruits in the list:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}