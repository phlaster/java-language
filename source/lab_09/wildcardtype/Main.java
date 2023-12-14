package ru.java.wildcardtype;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Создадим классы, описывающие работников
        ArrayList<Employee> listE = new ArrayList<>();

        listE.add(new Worker());
        listE.add(new Manager());
        listE.add(new Owner());

        for (Employee e: listE) {
            System.out.println(e);
        }

        System.out.println("-------------------");
        // 2. Создадим функцию, которая бы выводила список
        Main.Print1(listE);

        System.out.println("-------------------");
        // 3. Создадим другие списки
        ArrayList<Manager> listM = new ArrayList<>();
        listM.add(new Manager());
        listM.add(new Manager());
        listM.add(new Manager());

        ArrayList<Worker> listW = new ArrayList<>();
        listW.add(new Worker());
        listW.add(new Worker());
        listW.add(new Worker());

        ArrayList<Owner> listO = new ArrayList<>();
        listO.add(new Owner());
        listO.add(new Owner());
        listO.add(new Owner());

//        Main.Print1(listM);
//        Main.Print1(listW);
//        Main.Print1(listO);

        ArrayList<String> listS = new ArrayList<>();
        listS.add("String1");
        listS.add("String2");
        listS.add("String3");

        // 3.1
        Main.Print2(listM);
        System.out.println("-------------------");
        Main.Print2(listW);
        System.out.println("-------------------");
        Main.Print2(listO);
        System.out.println("-------------------");
        System.out.println("-------------------");

        // 3.2

        Main.Print3(listM);
        System.out.println("-------------------");
        Main.Print3(listW);
        System.out.println("-------------------");
        Main.Print3(listO);
        System.out.println("-------------------");

        // 4
        ArrayList<Integer> listInteger = new ArrayList<>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);

        ArrayList<Double> listDouble = new ArrayList<>();
        listDouble.add(1.0);
        listDouble.add(2.0);
        listDouble.add(3.0);

        ArrayList<Object> listObject = new ArrayList<>();
        listObject.add(new Integer(100));
        listObject.add(new Double(200.0));
        listObject.add("string");

        ArrayList<Number> listNumber = new ArrayList<>();
        listNumber.add(new Integer(10));
        listNumber.add(new Double(11));

        listNumber.add(new Number() {
            @Override
            public int intValue() {
                return 12;
            }

            @Override
            public long longValue() {
                return 12;
            }

            @Override
            public float floatValue() {
                return 12f;
            }

            @Override
            public double doubleValue() {
                return 12.0;
            }

//
//            public String toString() {
//                return "I am here";
//            }
        });


        System.out.println("-------------------");
        ArrayList<? extends Number> list1 = listInteger;
        System.out.println(list1.get(0));
        System.out.println(list1.get(1));
        System.out.println(list1.get(2));

        System.out.println("-------------------");
        list1 = listDouble;
        System.out.println(list1.get(0));
        System.out.println(list1.get(1));
        System.out.println(list1.get(2));

        System.out.println("-------------------");
        // нельзя, так как Object НЕ extends Number
//        list1 = listObject;
//        System.out.println(list1.get(0));
//        System.out.println(list1.get(1));
//        System.out.println(list1.get(2));

        list1 = listNumber;
        System.out.println(list1.get(0).intValue());
        System.out.println(list1.get(1).doubleValue());
        System.out.println(list1.get(2).floatValue());


        // читать можно, но писать нельзя
        // так как не понятно, какой же тип хранит list1
        // о типе известно, что он должен расширять Number
        // а это слишком мало информации
//        list1.add(new Integer(4));
//        list1.add(new Double(4));

        // 5
        // используем super, т.е. те классы, для которых Integer является super классом
        ArrayList<? super Integer> list2 = listInteger;
        System.out.println(list2.get(0));
        System.out.println(list2.get(1));
        System.out.println(list2.get(2));

        // нельзя, так как Integer - это не super для Double
        // list2 = listDouble;


        System.out.println("-------------------");
        list2 = listNumber;
        System.out.println( ((Integer) list2.get(0)).intValue());
        System.out.println( ((Double) list2.get(1)).doubleValue());
        // чтобы напечатать что-то осмысленное, нужно реализовать метод toString()
        System.out.println(list2.get(2));

        System.out.println("-------------------");
        // можно! но гарантируется доступ к Object, однако не понято, какой там конкретно лежит класс
        list2 = listObject;
        System.out.println(list2.get(0));
        System.out.println(list2.get(1));
        System.out.println(list2.get(2));

        // разрешается добавление Integer и его подклассов (не возможно, так как Integer объявлен как final
        list2.add(new Integer(22));


    }


    // 2.1
    public static void Print1 (ArrayList<Employee> list) {
        for (Employee e: list) {
            System.out.println(e);
        }
    }

    // 3.1
    public static void Print2 (ArrayList<?> list) {
        for (Object e: list) {
            System.out.println(e);
        }
    }

    // 3.2
    public static void Print3 (ArrayList<? extends Employee> list) {
        for (Employee e: list) {
            System.out.println(e);
        }
    }

}
