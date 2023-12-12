public class LabString {
    public static void main(String[] args) {
        System.out.println("Примеры методов для работы с объектами String...");
        String my_str = "   Привет, мир!   ";
        System.out.println(my_str);


        // Метод length() - возвращает длину строки
        int length = my_str.length();
        System.out.println("Длина строки:\n" + length);


        // Метод charAt() - возвращает символ по указанному индексу
        char firstChar = my_str.charAt(5);
        System.out.println("5-й символ строки:\n" + firstChar);


        // Метод substring() - возвращает подстроку начиная с указанного индекса
        String subStr = my_str.substring(8);
        System.out.println("Подстрока начиная с 8-го индекса:\n" + subStr);


        // Метод indexOf() - возвращает индекс первого вхождения указанной подстроки
        int index = my_str.indexOf("мир");
        System.out.println("Индекс первого вхождения подстроки 'мир':\n" + index);


        // Метод replace() - заменяет все вхождения указанной подстроки другой подстрокой
        String newStr = my_str.replace(" ", "_");
        System.out.println("Строка с замененным фрагментом:\n" + newStr);


        // Метод toUpperCase() и toLowerCase() - преобразуют строку к верхнему или нижнему регистру
        String upperCase = newStr.toUpperCase();
        String lowerCase = newStr.toLowerCase();
        System.out.println("Строка в верхнем регистре:\n" + upperCase);
        System.out.println("Строка в нижнем регистре:\n" + lowerCase);


        // Метод trim() - удаляет начальные и конечные пробелы
        String trimmedStr = my_str.trim();
        System.out.println("Строка после удаления начальных и конечных пробелов:\n" + trimmedStr);


        // Метод split() - разделяет строку на подстроки с помощью указанного разделителя
        String[] words = newStr.split(",");
        System.out.println("Разделение строки на подстроки по символу ',':");
        for (String word : words) {
            System.out.println(word);
        }


        // Метод equals() - сравнивает строки на равенство
        boolean isEqual = lowerCase.equals(upperCase);
        System.out.println("Равенство строк c учетом регистра: " + isEqual);


        // Метод equalsIgnoreCase() - сравнивает строки на равенство без учета регистра символов
        boolean isEqualIgnoreCase = lowerCase.equalsIgnoreCase(upperCase);
        System.out.println("Равенство строк без учета регистра: " + isEqualIgnoreCase);


        // Метод startsWith() и endsWith() - проверяют, начинается ли или заканчивается ли строка на указанную подстроку
        boolean startsWith = trimmedStr.startsWith("Привет");
        boolean endsWith = trimmedStr.endsWith("мир!");
        System.out.println("Строка начинается с 'Привет': " + startsWith);
        System.out.println("Строка заканчивается на 'мир!': " + endsWith);
    }
}
