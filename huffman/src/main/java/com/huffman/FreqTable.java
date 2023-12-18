package main.java.com.huffman;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class FreqTable {
    private Map<Byte, Integer> table;
    private int size;
    private int numPaddingBits;

    public FreqTable(String filename) {
        // Заглушка, реализация будет добавлена позже
    }

    public FreqTable(InputStream inputStream) {
        // Заглушка, реализация будет добавлена позже
    }

    public FreqTable(Map<Byte, Integer> freqTable) {
        // Заглушка, реализация будет добавлена позже
    }

    public void generateFreqTable(InputStream inputStream, Map<Byte, Integer> freqTable, int size) {
        // Заглушка, реализация будет добавлена позже
    }

    public void print() {
        // Заглушка, реализация будет добавлена позже
    }
}
