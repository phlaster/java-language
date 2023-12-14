package ru.java.hanoi;

public class StickManager {
    public static boolean move(Stick from, Stick to) {
        Disk d = from.pop();

        if (d == null) return false;

        if (to.push(d)) return true;

        from.push(d);
        return false;
    }
}
