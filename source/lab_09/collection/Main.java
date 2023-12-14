package ru.java.collection;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Интерфейсы Collection
        // Интерфейс Interator
        // Интерфейс Interable
        // найти в интернете картинку иерархии
        Collection<Integer> c = new ArrayList<>();
        //Iterator<Integer> i = c.iterator();

        c.add(1);
        c.add(2);
        c.add(3);
        c.add(4);
        c.add(5);

        // итератор нужно устанавливать ПОСЛЕ создания списка
        Iterator<Integer> i = c.iterator();
        while (i.hasNext()) {
            Integer item = i.next();
            System.out.println(item);
        }

        System.out.println("----------------------");

        for (Integer item : c) {
            System.out.println(item);
        }

        System.out.println("----------------------");
        // удаление элементов
        i = c.iterator();
        while (i.hasNext()) {
            Integer item = i.next();
            System.out.println(item);
            // метод remove удаляет элемент, который был возвращен при последнем вызове next()
            // перед remove нужно обязательно вызвать next
            i.remove();
        }

        System.out.println("----------------------");
        for (Integer item : c) {
            System.out.println(item);
        }

        // Типы коллекций для рассмотрения
        // Индексированная динамически расширяющася и сокращающаяся последовательность
        List<Integer> al = new ArrayList<>();
        // Упорядоченная последовательность, допускающая эффективную вставку и удаление на любой позиции
        List<Integer> ll1 = new LinkedList<>();
        Deque<Integer> ll2 = new LinkedList<>();
        // Двунаправленная очередь, реализуемая в виде циклического массива
        Queue<Integer> ad = new ArrayDeque<>();
        // Неупорядоченная коллекция, исключающая дубликаты
        Set<Integer> hs = new HashSet<>();
        // Отсортированное множество
        SortedSet<Integer> ts1 = new TreeSet<>();
        Set<Integer> ts2 = new TreeSet<>();
        // Множество значений перечислимого типа
        EnumSet<Size> es = EnumSet.of(Size.S, Size.M, Size.L);
        // Множество, запоминающее порядок ввода элементов
        Set<Integer> lhs = new LinkedHashSet<>();
        // Коллекция, позволяющая эффективно удалять наименьший элемент
        Queue<Integer> pq = new PriorityQueue<>();
        // Структура данных для хранения связанных вместе пар "ключ-значение"
        Map<Integer, Integer> hm = new HashMap<>();
        // Отображение с отсортированными ключами
        Map<Integer, Integer> tm1 = new TreeMap<>();
        SortedMap<Integer, Integer> tm2 = new TreeMap<>();
        // Отображение с ключами, относящимися к перечислимому типу
        Map<Size, Integer> em = new EnumMap<>(Size.class);
        // Отображение с запоминанием порядка, в котором добавлялись элементы
        Map<Integer, Integer> lhm = new LinkedHashMap<>();
        // Отображение со значениями, которые могут удаляться системой сборки мусора, если они больше нигде не используются
        Map<Integer, Integer> whm = new WeakHashMap<>();
        // Отображение с ключами, сравниваемыми с помощью операции ==, а не через equals
        Map<Integer, Integer> ihm = new IdentityHashMap<>();
    }
}

enum Size {
    S, M, L;
}
