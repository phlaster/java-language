package ru.java.exception;

/*
Исключения - это один из способов обработки ошибок
Исключение - это экземпляр класса, производного от Throwable

1) Создадим класс Exception_01, производный от Throwable

2) google: иерархия исключений java
Иерархия исключений Java делится на две ветки: Error и Exception
Error - под-иерархия исключений, описывающая внутренние ошибки и ситуации, возникающие в связи с нехваткой ресурсов в исполняющей системе Java.
Exception - все остальные исключения, которые опять же делятся на RuntimeException и остальные.
Исключения типа RuntimeException возникают в следствии ошибко при программировании, т.е. они практически всегда возникают по вине программиста
Основные причины RuntimeException:
* неверное приведение типов
* выход за пределы массива
* попытка обратится к объекту по пустой ссылке null
Остальные исключения - это больше стечение обстоятельств
* открытие несуществующего файла
* попытка получить объект Class из строки, в которой находится неправильное имя
Все исключения, наследуемые от Error и RuntimeException - непроверяемые. Остальные исключения - проверяемые, т.е. компилятор проверяет наличие соответствующих обработчиков

3) При реализации классов в их методах можно указывать, какие исключения могут возникнуть.
Речь идет только о проверяемых исключениях
Это позволит при использовании класса обработать данные исключения

*) Можно создавать свою иерархию исключений, а можно использовать и менять существующую
 */
public class Main {
    public static void main(String[] args) throws Exception_01 {

        // 1
        Exception_01 exc01 = new Exception_01();
        // 1.1 исключение может быть брошено и поймано внутри try / catch
        try {
            throw exc01;
        } catch (Exception_01 e) {
            System.out.println("Exception_01 caught");
        }

        // 1.2 исключение может быть брошено и проброшено далее через throws Exception_01 в функции main
//        throw exc01;

        // 2 Создадим Exception_02, пронаследованный от RuntimeException
        // никто не требует, чтобы данное исключение было обработано
//        throw new Exception_02();

        // 3 Создадим SomeClass + SomeClassException + SomeClassStringIsEmptyException
        SomeClass sc1 = new SomeClass("string");
        SomeClass sc2 = new SomeClass();

        try {
            sc1.Method();
            sc2.Method();
        } catch (SomeClassStringIsEmptyException e) {
            System.out.println(e.getMessage());
        }

        // 4 Обработка нескольких исключений. В порядке появления и без повторений
        // ! Поменять местами исключения нельзя !
        try {
            sc2.Method();
        } catch (SomeClassStringIsEmptyException e) {
            System.out.println(e.getMessage());
        } catch (SomeClassException e) {
            System.out.println(e.getMessage());
        }

        // 5 Можно из catch выбросить новое исключение и понять его причину
        try {
            try {
                sc2.Method();
            } catch (SomeClassStringIsEmptyException e) {
                System.out.println(e.getMessage());
                Exception_01 e_01 = new Exception_01();
                e_01.initCause(e);
                throw e_01;
            }
        } catch (Exception_01 e) {
            System.out.println("I caught Exception_01");
            System.out.println("The prev exception was " + e.getCause().getMessage());
        }

        // 6 использование finally
        try {
            sc2.Method();
        } catch (SomeClassStringIsEmptyException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("I am in finally");
        }


        try {
//            throw new Exception_02();
        } finally {
            System.out.println("I am in finally");
        }

        // 7 stack trace
        try {
            sc2.Method();
        } catch (SomeClassStringIsEmptyException e) {
            StackTraceElement[]  ste = e.getStackTrace();
            e.printStackTrace(System.out);
        }
    }
}
