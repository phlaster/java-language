import java.lang.reflect.*;

public class LabReflection {
    public static void printClassInfo(Class<?> inspected) {
        // Получаем информацию о полях класса
        Field[] fields = inspected.getDeclaredFields();
        System.out.println("----------Поля: ----------");
        for (Field field : fields) {
            System.out.println("    " + field.getName() + " - " + field.getType());
        }

        // Получаем информацию о методах класса
        Method[] methods = inspected.getDeclaredMethods();
        System.out.println("\n----------Методы: ----------");
        for (Method method : methods) {
            System.out.println("    " + method.getName() + " - " + method.getReturnType());
        }

        // Получаем информацию о конструкторах класса
        Constructor<?>[] constructors = inspected.getDeclaredConstructors();
        System.out.println("\n----------Конструкторы: ----------");
        for (Constructor<?> constructor : constructors) {
            System.out.println("    " + constructor.getName() + " - " + constructor.getParameterCount() + " parameters");
        }

        // Получаем информацию об интерфейсах, которые реализует класс
        Class<?>[] interfaces = inspected.getInterfaces();
        System.out.println("\n----------Интерфейсы: ----------");
        for (Class<?> interf : interfaces) {
            System.out.println("    " + interf.getName());
        }

        // Получаем информацию о суперклассе
        Class<?> superClass = inspected.getSuperclass();
        if (superClass != null) {
            System.out.println("\n----------Суперкласс: ----------\n    " + superClass.getName());
        }
    }

    public static void main(String[] args) {
        // Пример использования: выведем информацию о классе String
        LabReflection.printClassInfo(String.class);
    }
}
