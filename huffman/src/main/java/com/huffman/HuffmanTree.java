package main.java.com.huffman;

import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class HuffmanTree {
    private Node root;
    private int numLeaves;
    private int numNodes;

    public HuffmanTree(FreqTable freqTable) {
        this.numLeaves = 0;
        this.numNodes = 0;

        PriorityQueue<Node> pQueue = new PriorityQueue<>((lhs, rhs) -> Integer.compare(lhs.getFrequency(), rhs.getFrequency()));
        for (Map.Entry<Byte, Integer> entry : freqTable.getTable().entrySet()) {
            pQueue.add(new Node(entry.getKey(), entry.getValue(), null, null));
            this.numNodes++;
            this.numLeaves++;
        }
        while (pQueue.size() > 1) {
            Node left = pQueue.poll();
            Node right = pQueue.poll();

            int combinedFreq = left.getFrequency() + right.getFrequency();
            Node parent = new Node((byte) 0, combinedFreq, null, null);

            parent.setLeft(left);
            parent.setRight(right);

            pQueue.add(parent);
            this.numNodes++;
        }
        this.root = pQueue.peek();
    }

    public Node getRoot() {
        return this.root;
    }

    public void print() {
        System.out.println("Дерево Хаффмана:");
        System.out.println("Количество узлов: " + this.numNodes);
        System.out.println("Количество листьев: " + this.numLeaves);

        Queue<Node> q = new LinkedList<>();
        q.add(this.root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                Node curr = q.poll();

                if (curr.isLeaf()) {
                    System.out.print(curr.getByteValue() + " (" + curr.getFrequency() + ") ");
                } else {
                    System.out.print("( ) ");
                    q.add(curr.getLeft());
                    q.add(curr.getRight());
                }
            }
            System.out.println();
        }
    }
}
