package ru.java.hanoi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hanoi");

        ArrayList<Stick> sticks = new ArrayList(Arrays.asList(new Stick("1"), new Stick("2"), new Stick("3")));

        Stick s1 = sticks.get(0);
        Stick s2 = sticks.get(1);
        Stick s3 = sticks.get(2);


        for (int i = 10; i > 0; i--) {
            s1.push(new Disk(i));
        }
        System.out.println("Step");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        StickManager.move(s1, s2);
        System.out.println("Step");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        StickManager.move(s1, s3);
        System.out.println("Step");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        StickManager.move(s2, s3);
        System.out.println("Step");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

    }
}
