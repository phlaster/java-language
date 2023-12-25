package main.java.com.huffman;

import java.util.HashMap;
import java.util.Map;
import java.io.FileInputStream;
import java.io.IOException;

class FreqTable {
    private Map<Byte, Integer> table;
    private int size;
    private int numPaddingBits;

    public FreqTable(String filename) throws IOException {
        FileInputStream inputStream = new FileInputStream(filename);
        generateFreqTable(inputStream);
        inputStream.close();
    }

    public FreqTable(Map<Byte, Integer> freqTable) {
        this.table = freqTable;
        this.size = freqTable.size();
    }

    public Map<Byte, Integer> getTable(){
        return this.table;
    }

    private void generateFreqTable(FileInputStream inputStream) throws IOException {
        table = new HashMap<>();
        int byteValue;
        while ((byteValue = inputStream.read()) != -1) {
            byte byteKey = (byte) byteValue;
            table.put(byteKey, table.getOrDefault(byteKey, 0) + 1);
        }
        size = table.size();
    }

    public void print() {
        System.out.println("Таблица частот встречающихся байтов:");
        System.out.println("Длина: " + size);
        System.out.println("ASCII байт  частота");
        for (Map.Entry<Byte, Integer> entry : table.entrySet()) {
            byte byteKey = entry.getKey();
            int freq = entry.getValue();
            int byteValue = byteKey & 0xFF;
            if (33 <= byteValue && byteValue <= 126) {
                System.out.print((char) byteValue + "     ");
            } else {
                System.out.print("      ");
            }
            System.out.println(byteValue + "   " + freq);
        }
    }
}
