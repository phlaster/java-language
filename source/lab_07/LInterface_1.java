package ru.java;

public interface LInterface_1 {
    // 2. интерфейс - это не класс
    // все методы по умолчанию public
    // в интерфейсе не может быть методов private или protected
    // в интерфейсе не может быть полей, но можно определить константы
    // по умолчанию константы public static final
    int ICONST = 10;
    /* public */ void Method1();
    // 6. метод по умолчанию. Сначала без default и без {}
    default void Method2() {
        System.out.println("LInterface_1::Method2()");
    };
}
