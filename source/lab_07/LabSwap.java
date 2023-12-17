// package source.lab_07;

public class LabSwap {
    private int value;

    public LabSwap(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static void exchangeValues(LabSwap item1, LabSwap item2) {
        int temp = item1.getValue();
        item1.setValue(item2.getValue());
        item2.setValue(temp);
    }
}