package ru.java;

public class LClassInterface implements LInterface_1, LInterface_2 {
    public static void main(String[] args) {
        // 1. Класс реализует интерфейс
        LClassInterface ci = new LClassInterface();
        LInterface_1 ci1 = new LClassInterface();
        // нельзя создать экземпляр интерфейса
//        LInterface ci2 = new LInterface();

        ci.Method1();
        ci1.Method1();

        System.out.println(ci.ICONST);
        System.out.println(ci1.ICONST);

        // менять константы нельзя
//        ci.ICONST = 1;

        // 2. Можно реализовать много интерфейсов
        // добавить LInterface_2
        // интерфейс не обязательно должен иметь методы
        // факт реализации интерфейса может просто говорить о каком-либо свойстве класса, имеющем смысл при решении конкретной задачи
        LInterface_2 ci2 = new LClassInterface();
        // посмотреть, что можно вызвать у ci2, только из Object

        // 3. Добавим третий интерфейс и проверим, какие интерфейсы реализует класс

        System.out.println( (ci1 instanceof LInterface_1) ? "LInterface_1 - ok" : "LInterface_1 - NOT");
        System.out.println( (ci1 instanceof LInterface_2) ? "LInterface_2 - ok" : "LInterface_2 - NOT");
        System.out.println( (ci1 instanceof LInterface_3) ? "LInterface_3 - ok" : "LInterface_3 - NOT");

        // 4. Интерфейс может сам расширять интерфейсы (не не классы)
        // Понимайте разницу между extends & implements
        // LInterface_4

        // 5. Интерфейс может содержать статические методы
        // LInterface_4
        LInterface_4.PrintSomething();

        // 6. Интерфейс может содержать методы с реализацией по умолчанию
        ci.Method2();
    }

    // 3. При реализации public нужно указать
    public void Method1() {
        System.out.println("LClassInterface::Method1()");
    }
}
