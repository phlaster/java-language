package ru.java.lambda;

import ru.au.java.callback.*;

public class LLambdaMain {
    public static void main(String[] args) {
        // 1. Лямбда-выражения - способ определения блоков кода, которые можно выполнять отложенно или по нескольку раз
        // 2. рассмотрим функцию printN
        // Чтобы вызвать этот метод или подобный ему по сигнатуре метод из другой функции надо создать экземпляр класса, реализующий определенный интерфейс (как callback) и передавать его
        // Есть способ попроще

//        (int n) -> {
//            for (int i = 0; i < n; i++) {
//                System.out.print(i + ",");
//            }
//            System.out.println();
//        }

        // Это и есть лямбда-выражение

        // Вернемся к примеры с Callback

        LCallbackMain cm = new LCallbackMain();
        cm.init(() -> System.out.println("result0"));
        cm.init(() -> System.out.println("result1"));
        cm.init(() -> System.out.println("result2"));
        cm.init(() -> System.out.println("result3"));

        cm.sendNotification();

        // Moжно написать так
        LINotifier lin = () -> System.out.println("my notifier");
        lin.mynotify();

        // лямбда-выражение совместимо с функциональным интерфейсом (интерфейс, который имеет только один метод)

        // 3. Добавим интерфейс LLambdaInterface_1
        LLambdaInterface_1 ll1 = new LLambdaMain()::printN;
        ll1.Method(15);

        // добавляем внешнюю переменную
        String finish = "FINISH";
        LLambdaInterface_1 ll2 = (int n) -> {
            for (int i = 0; i < n; i++) {
                System.out.print(i + ",");
            }
            System.out.println(finish);
//            System.out.println();
        };
        ll2.Method(10);

        // Нельзя менять переменную, которая используется внутри замкания
//        finish = "START";

        ll2.Method(12);

    }

    // 2.
    public void printN(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
