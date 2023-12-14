package ru.java.algo;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Algorithms");

        // При собственной реализации алгоритмов над коллекциями
        // думайте в терминах интерфейсов и выбирайте минимальный, но
        // содержащий все необходимые элементы
        // 1. Реализация поиска минимального элемента по коллекции
        // 2. Использование

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        Random r = new Random();
        for (int i =  0; i < 10 ; i++) {
            arrayList.add(r.nextInt());
            linkedList.add(r.nextInt());
        }

        System.out.print("arrayList :");
        System.out.println(arrayList);
        System.out.println("ArrayList max = " + Main.max(arrayList));

        System.out.print("linkedList :");
        System.out.println(linkedList);
        System.out.println("LinkedList max = " + Main.max(linkedList));

        // 3. Как сделать сортировку коллекции?
        // Смотрим на иерархию
//        List<Integer> list = new ArrayList<>(); // есть сортировка, так как имеет смысл
//        Queue<Integer> queue = new PriorityQueue<>(); // нет сортировки
//        Set<Integer> set = new HashSet<>(); // нет сортировки

        ArrayList<Integer> arrayList2 = (ArrayList<Integer>) arrayList.clone();

        System.out.print("arrayList2 :");
        System.out.println(arrayList2);

//        arrayList.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer t1, Integer t2) {
//                if (t1 > t2) return 1;
//                if (t1 < t2) return -1;
//                return 0;
//            }
//        });
//
//        System.out.println(arrayList);

        // можно не писать компоратор самому
        arrayList.sort(Comparator.comparingInt(integer -> integer.intValue()));
//        arrayList.sort(Comparator.comparingInt(integer -> integer));
        System.out.println(arrayList);

        // Сортировка возможна через Collections
        Collections.sort(arrayList2);
        System.out.println(arrayList2);

        // Обратный порядок
        // Элементы - Object, поэтому нужно привести к Integer
        Collections.sort(arrayList2, Comparator.comparingInt(integer -> ((Integer)integer)).reversed());
        System.out.println(arrayList2);


        // 4. Двоичный поиск. Имеет смысл, когда элементу отсортированы
        // В неотсортированном массиве результат непредсказуем
        ArrayList<Integer> arrayList_1 = new ArrayList<>();
        ArrayList<Integer> arrayList_2 = new ArrayList<>();

        r = new Random();
        for (int i =  0; i < 10 ; i++) {
            int rnd = r.nextInt();
            arrayList_1.add(rnd);
            arrayList_2.add(rnd);
        }

        Integer toSearch = arrayList_1.get(7);
        System.out.println("To Search: " + toSearch);

        try {
            int index_1 = Collections.binarySearch(arrayList_1, toSearch);
            // иногда возвращается отрицательное значение - значит элемент не найден (потому что массив не отсортирован)
            System.out.println(arrayList_1);
            System.out.println("1: " + arrayList_1.get(index_1));
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        Collections.sort(arrayList_2);
        System.out.println(arrayList_2);
        int index_2 = Collections.binarySearch(arrayList_2, toSearch);
        System.out.println("2: " + arrayList_2.get(index_2));

        // 5. В класс Collections включены также простые алгоритмы
        ArrayList<String> arrayList_ABC = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        System.out.println(arrayList_ABC);

        Collections.replaceAll(arrayList_ABC, "A", "Z");
        System.out.println(arrayList_ABC);

        ArrayList<String> arrayList_ABC2 = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        System.out.println(arrayList_ABC2);

        // 6. Операции с множествами

        // удалить все элемента, содержащиеся в arrayList_ABC
//        arrayList_ABC2.removeAll(arrayList_ABC);
//        System.out.println(arrayList_ABC2);

        // удалить все элементы, отсутствующие в arrayList_ABC, т.е. оставить только общие
        arrayList_ABC2.retainAll(arrayList_ABC);
        System.out.println(arrayList_ABC2);

        // операции могут относиться к Map & Set
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");
        map.put(5, "E");
        map.put(6, "F");
        map.put(7, "G");

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        System.out.println(map);
        System.out.println(set);

//        map.keySet().removeAll(set);
//        System.out.println(map);

        map.keySet().retainAll(set);
        System.out.println(map);

    }

    // 1.
    public static <T extends Comparable> T max(Collection<T> c) {
        if (c.isEmpty()) throw new NoSuchElementException();

        Iterator<T> it = c.iterator();
        T theMax = it.next();
        while (it.hasNext()) {
            T item = it.next();
            if (theMax.compareTo(item) < 0) {
                theMax = item;
            }
        }
        return theMax;
    }
}
