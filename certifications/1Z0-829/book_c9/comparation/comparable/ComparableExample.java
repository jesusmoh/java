package book_c9.comparation.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student> {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Method:

    // The compareTo(Object obj) method is used to compare the current object with a
    // specified object and returns an integer value indicating their relative
    // order.

    @Override
    public int compareTo(Student other) {
        return this.name.length() - other.name.length(); // Compare students name lenght
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

public class ComparableExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 101));
        students.add(new Student("Bob", 103));
        students.add(new Student("Charlie", 102));

        Collections.sort(students); // Sort students based on ID

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
