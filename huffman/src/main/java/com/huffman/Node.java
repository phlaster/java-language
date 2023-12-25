package main.java.com.huffman;

public class Node {
    private byte byteValue;
    private int frequency;
    private Node left;
    private Node right;

    public Node(byte byteValue, int frequency, Node left, Node right) {
        this.byteValue = byteValue;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    public void setLeft(Node node){
        this.left = node;
    }

    public void setRight(Node node){
        this.right = node;
    }

    public byte getByteValue() {
        return byteValue;
    }

    public int getFrequency() {
        return frequency;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public boolean isLeaf() {
        return (left == null && right == null);
    }

    public boolean isGreaterThan(Node other) {
        return frequency > other.frequency;
    }
}
