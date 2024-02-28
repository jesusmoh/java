package book_c10.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

class Employee {
    private String name;
    private double salary;
    private boolean active;

    public void setActive(boolean active) {
        this.active = active;
    }

    public Employee(String name, double salary, boolean active) {
        this.name = name;
        this.salary = salary;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public boolean isActive() {
        return active;
    }
}

public class StreamOperations {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 5080, true));
        employees.add(new Employee("Bob", 6070, true));
        employees.add(new Employee("Charlie", 456, true));
        employees.add(new Employee("Enzo", 1, false));
        employees.add(new Employee("Jesus", 60004, true));
        employees.add(new Employee("Manuel", 45003, true));

        List<Employee> employeesN = new ArrayList<>();
        employeesN.add(new Employee("Peb", 5080, true));

        // count
        var size = employees.stream().count();

        // max salary
        var max = employees.stream().max((x, y) -> { // override to comparable
            return (x.getSalary() < y.getSalary() ? 1 : -1);
        });
        System.out.println(max.get());

        // higest Employye salary active
        var sumactive = employees.stream()
                .reduce((e1, e2) -> e1.getSalary() > e2.getSalary() && e1.isActive() && e2.isActive() ? e1 : e2);
        System.out.println(sumactive);

        // sum all
        double totalSalaryActive = employees.stream()
                .reduce(0.0, (accumulator, ex) -> ex.isActive() ? accumulator + ex.getSalary() : accumulator,
                        Double::sum);

        System.out.println(totalSalaryActive);

        double sumAll = employees.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println(sumAll);

        // X match
        Predicate<Employee> pred = x -> Character.isLetter(x.getName().charAt(0)) && x.getName().length() >= 2;
        var t = employees.stream().anyMatch(pred);
        System.out.println(t);

        // You can not opera 2 times over the same stream
        // employees.forEach(System.out::println);
        // employees.forEach(System.out::println);

        Stream.concat(employees.stream(), employeesN.stream()).forEach(x -> System.out.println(x));

    }
}