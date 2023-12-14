// package source.lab_06;

import java.util.EmptyStackException;

public class LabStack {
    private int maxSize;
    private int[] stackArray;
    private int currentSize;

    // Конструктор стека
    public LabStack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.currentSize = 0;
    }

    // Добавление элемента в стек
    public void push(int value) {
        if (currentSize == maxSize) {
            // Расширение статического массива при переполнении стека
            maxSize *= 2;
            int[] newStack = new int[maxSize];
            System.arraycopy(stackArray, 0, newStack, 0, maxSize);
            stackArray = newStack;
        }
        stackArray[currentSize++] = value;
    }

    public int pop() {
        if (currentSize == 0) {
            throw new EmptyStackException();
        }
        return stackArray[currentSize--];
    }

    public int peek() {
        if (currentSize == 0) {
            throw new EmptyStackException();
        }
        return stackArray[currentSize];
    }

    public boolean isEmpty() {
        return (currentSize == 0);
    }

    public int size() {
        return currentSize;
    }
}
