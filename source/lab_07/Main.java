package source.lab_07;

public class Main {
    public static void main(String[] args) {
        LabSwap item1 = new LabSwap(5);
        LabSwap item2 = new LabSwap(10);

        System.out.println(
            "Before exchange: item1 value = " + item1.getValue() +
            ", item2 value = " + item2.getValue()
        );

        // Выполняем обмен значений
        LabSwap.exchangeValues(item1, item2);

        System.out.println(
            "After exchange: item1 value = " + item1.getValue() +
            ", item2 value = " + item2.getValue()
        );
    }
}
