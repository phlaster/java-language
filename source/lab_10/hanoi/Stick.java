package ru.java.hanoi;

import java.util.ArrayDeque;
import java.util.Deque;

public class Stick {

    private String name;
    private Deque<Disk> stack;

    public Stick(String name) {
        this.name = name;
        this.stack = new ArrayDeque<>();
    }

    public boolean push(Disk d) {
        if (stack.isEmpty()) {
            stack.addLast(d);
            return true;
        }

        Disk top = stack.getLast();
        if (top.getSize() > d.getSize()) {
            stack.addLast(d);
            return true;
        }

        return false;
    }

    public Disk pop() {
        return stack.pollLast();
    }

    public String toString() {
        return name + ":" + stack.toString();
    }
}
