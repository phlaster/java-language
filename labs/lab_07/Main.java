// package source.lab_07;

public class Main {
    public static void main(String[] args) {
        LabSwap obj1 = new LabSwap(5);
        LabSwap obj2 = new LabSwap(10);

        System.out.println(
            "Перед обменом: obj1 = " + obj1.getValue() +
            ", obj2 = " + obj2.getValue()
        );

        // Выполняем обмен значений
        LabSwap.exchangeValues(obj1, obj2);

        System.out.println(
            "После обмена: obj1 = " + obj1.getValue() +
            ", item2 = " + obj2.getValue()
        );
    }
}
