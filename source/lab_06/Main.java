// package source.lab_06;

public class Main {
    public static void main(String[] args) {
        LabStack stack = new LabStack(5);

        System.out.println("Стек пустой? " + stack.isEmpty());

        System.out.println("Размер стека: " + stack.size());
        stack.push(1);
        System.out.println("Размер стека: " + stack.size());
        stack.push(2);
        System.out.println("Размер стека: " + stack.size());
        stack.push(3);

        System.out.println("Стек пустой? " + stack.isEmpty());
        System.out.println("Размер стека: " + stack.size());
        System.out.println("Верхний элемент: " + stack.peek());

        System.out.println("Popped: " + stack.pop());
        System.out.println("Верхний элемент: " + stack.peek());
        System.out.println("Размер стека: " + stack.size());
    }
}
