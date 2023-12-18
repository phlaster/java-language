import java.lang.reflect.*;

public class LabReflectionInstance {
    public static void main(String[] args) {
        try {
            // Получаем информацию о классе по его имени
            Class<?> myClass = Class.forName("MyClass");

            // Создаем экземпляр класса, предполагая, что у класса есть конструктор без параметров
            Object instance = myClass.getDeclaredConstructor().newInstance();

            // Получаем метод по его имени
            Method method = myClass.getDeclaredMethod("myMethod");

            // Вызываем метод для созданного экземпляра
            method.invoke(instance);

        } catch (ClassNotFoundException e) {
            System.out.println("Класс не найден: " + e);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Ошибка при вызове метода: " + e);
        }
    }
}
