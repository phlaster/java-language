package pkg_06;

import java.util.EmptyStackException;

public class LabStack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    // Конструктор стека
    public LabStack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }

    // Добавление элемента в стек
    public void push(int value) {
        if (top == maxSize - 1) {
            // Реализуем механизм расширения массива при переполнении
            maxSize *= 2;
            int[] newStack = new int[maxSize];
            System.arraycopy(stackArray, 0, newStack, 0, maxSize);
            stackArray = newStack;
        }
        stackArray[++top] = value;
    }

    public int pop() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        return stackArray[top--];
    }

    public int peek() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public int size() {
        return top + 1;
    }
}
