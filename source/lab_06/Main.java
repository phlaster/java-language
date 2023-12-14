package pkg_06;

public class Main {
    public static void main(String[] args) {
        LabStack stack = new LabStack(5);

        System.out.println("Is the stack empty? " + stack.isEmpty()); // Должно вывести "Is the stack empty? true"

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Is the stack empty? " + stack.isEmpty()); // Должно вывести "Is the stack empty? false"
        System.out.println("Stack size: " + stack.size()); // Должно вывести "Stack size: 3"
        System.out.println("Top element: " + stack.peek()); // Должно вывести "Top element: 30"

        System.out.println("Popped: " + stack.pop()); // Должно вывести "Popped: 30"
        System.out.println("Top element: " + stack.peek()); // Должно вывести "Top element: 20"
    }
}
