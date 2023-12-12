public class LabSwitch {
    public static void main(String[] args) {
        System.out.println("Использование символьного типа:");
        char symbol = 'A';
        switch (symbol) {
            case 'A':
                System.out.println("Символ A");
                break;
            case 'B':
                System.out.println("Символ B");
                break;
            default:
                System.out.println("Другой символ");
        }


        System.out.println("\nИспользование строкового типа:");
        String s = "Пятачок";
        switch (s) {
            case "Ниф-Ниф":
                System.out.println("Домик из соломы");
                break;
            case "Нуф-Нуф":
                System.out.println("Домик из веток");
                break;
            case "Наф-Наф":
                System.out.println("Кирпичный дом");
                break;
            default:
                System.out.println("Дом на дереве");
        }


        System.out.println("\nИспользование целочисленного типа:");
        Integer i = 2;
        switch (i) {
            case 1:
                System.out.println("Вариант 1");
                break;
            case 2:
                System.out.println("Вариант 2");
                break;
            case 3:
                System.out.println("Вариант 3");
                break;
            default:
                System.out.println("Другой вариант");
        }


        enum Season {
            SPRING, SUMMER, AUTUMN, WINTER
        }
        System.out.println("\nИспользование enum:");
        Season currentSeason = Season.SUMMER;
        switch (currentSeason) {
            case SPRING:
                System.out.println("Весна!");
                break;
            case SUMMER:
                System.out.println("Лето!");
                break;
            case AUTUMN:
                System.out.println("Осень!");
                break;
            case WINTER:
                System.out.println("Зима!");
                break;
            default:
                System.out.println("Неверное значение!");
        }
    }
}
