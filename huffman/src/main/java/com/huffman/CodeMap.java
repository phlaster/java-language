package main.java.com.huffman;

import java.util.HashMap;
import java.util.Map;

public class CodeMap {
    private Map<Byte, String> map;
    private int size;

    public CodeMap(Node root, String initialCode) {
        this.map = new HashMap<>();
        generateCodes(root, initialCode);
        this.size = this.map.size();
    }

    public String at(byte c) {
        return this.map.get(c);
    }

    private void generateCodes(Node nodePtr, String currentPrefix) {
        if (nodePtr == null) {
            return;
        }
        if (nodePtr.isLeaf()) {
            this.map.put(nodePtr.getByteValue(), currentPrefix);
        }

        generateCodes(nodePtr.getLeft(), currentPrefix + "0");
        generateCodes(nodePtr.getRight(), currentPrefix + "1");
    }

    public void print() {
        System.out.println("Словарь кодов Хаффмана:\nДлина:" + size + "\nASCII байт код");
        for (Map.Entry<Byte, String> entry : map.entrySet()) {
            int byteValue = entry.getKey() & 0xFF;
            if (33 <= byteValue && byteValue <= 126) {
                System.out.print((char) byteValue + "     ");
            } else {
                System.out.print("      ");
            }
            System.out.println(byteValue + "  '" + entry.getValue() + "'");
        }
    }
}
