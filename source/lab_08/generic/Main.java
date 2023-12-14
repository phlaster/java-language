package ru.java.generic;

public class Main {
    public static void main(String[] args) {

        // 1
        PairInt p1 = new PairInt();
        PairInt p2 = new PairInt(1,2);

        // 2
        Pair<Integer> pi1 = new Pair<Integer>();
        Pair<Integer> pi2 = new Pair<>(1, 2);

        // 3 Создать элементы с разными типами
        UPair<Integer, Double> pid1 = new UPair<Integer, Double>();
        UPair<Integer, Double> pid2 = new UPair<>(1, 2.13);

        // 4 Обобщенный метод
        Main.Method("string");
        Main.Method(1);
        Main.Method(new Integer(10));
        Main.Method(1.23);

        // 5 ограничения на обощенный тип
        // BaseI + BaseC + Derived + RPair
//        RPair<BaseI> rp1;
//        RPair<BaseC> rp2;
//        RPair<Derived> rp3;
//        RPair<Integer> rp4;



    }

    public static<T> void Method(T v) {
        System.out.println(v);
    }
}
