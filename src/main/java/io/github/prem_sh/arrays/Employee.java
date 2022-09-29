package io.github.prem_sh.arrays;

public class Employee implements Comparable<Employee> {
    Integer id;
    String name;
    Long salary;

    public Employee(Integer id, String name, Long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee o) {
        return id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return id + "|" + name + "|" + salary;
    }
}
