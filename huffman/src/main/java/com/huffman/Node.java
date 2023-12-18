package main.java.com.huffman;

public class Node {
    public char data;
    public int frequency;
    public Node left;
    public Node right;

    public Node(char data, int frequency, Node left, Node right) {
        this.data = data;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public boolean isGreaterThan(Node other) {
        return this.frequency > other.frequency;
    }
}
