package ru.java.wildcardtype;

public class Employee {
    private static int COUNTER = 0;
    protected int number;
    public Employee() {
        this.number = ++COUNTER;
    }

    public String toString() {
        return "Employee (" + this.number + ")";
    }
}
