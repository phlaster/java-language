public class Main {
    public static void main(String[] args) {
        // Тройка целых чисел
        Triple<Integer> tripleInt = new Triple<>(5, 10, 3);
        System.out.println("Min (Integer): " + tripleInt.min());
        System.out.println("Max (Integer): " + tripleInt.max());
        System.out.println("Mean (Integer): " + tripleInt.mean());


        // Тройка с плавающей запятой
        Triple<Double> tripleDouble = new Triple<>(2.0, 17.3, -4.7);
        System.out.println("Min (Double): " + tripleDouble.min());
        System.out.println("Max (Double): " + tripleDouble.max());
        System.out.println("Mean (Double): " + tripleDouble.mean());


        // Тройка строк
        Triple<String> tripleString = new Triple<>("apple", "orange", "banana");
        System.out.println("Min (String): " + tripleString.min());
        System.out.println("Max (String): " + tripleString.max());
        try {
            System.out.println("Mean (String): " + tripleString.mean()); // Здесь будет выброшено исключение
        } catch (ArithmeticException e) {
            System.out.println("Было выброшено исключение: " + e);
        }

    }
}
