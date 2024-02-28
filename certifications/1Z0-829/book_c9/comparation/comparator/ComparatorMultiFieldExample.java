import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class MultiFieldComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        int nameCompare = s1.getName().compareTo(s2.getName());
        if (nameCompare == 0) {
            return Integer.compare(s1.getAge(), s2.getAge());
        }
        return nameCompare;
    }
}

public class ComparatorMultiFieldExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 21));
        students.add(new Student("Bob", 23));
        students.add(new Student("Alice", 22));

        Collections.sort(students, new MultiFieldComparator());

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
