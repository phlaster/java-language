package main.java.com.huffman;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;

public class Huffman {
    private static int encodeData(DataInputStream inputStream, DataOutputStream outputStream, CodeMap codeMap) throws IOException {
        int numEncodedBits = 0;
        byte currentByte = 0;
        byte bakingByte = 0x00;
        int bitPos = 0;
        while (inputStream.available() > 0) {
            currentByte = inputStream.readByte();
            String code = codeMap.at(currentByte);
            for (char c : code.toCharArray()) {
                if (c == '1') {
                    bakingByte |= (0x80 >> bitPos);
                }
                bitPos++;
                numEncodedBits++;

                if (bitPos > 7) {
                    outputStream.writeByte(bakingByte);
                    bakingByte = 0x00;
                    bitPos = 0;
                }
            }
        }
        if (bitPos > 0) {
            byte numPaddingBits = (byte) (0x8 - bitPos);
            outputStream.writeByte(bakingByte);
            outputStream.writeByte(numPaddingBits);
        }
        return numEncodedBits;
    }

    private static SimpleEntry<Integer, Integer> getPaddingBitsAndFSize(FileInputStream fileStream) throws IOException {
        long currentPosition = fileStream.getChannel().position();
        fileStream.getChannel().position(0);
        long fileSize = fileStream.getChannel().size();
        fileStream.getChannel().position(fileSize - 1);

        byte lastByte = (byte) fileStream.read();
        int numBytesRemaining = (int) (fileSize - currentPosition);
        int numPaddingBits = lastByte & 0xFF;

        fileStream.getChannel().position(currentPosition);

        return new SimpleEntry<>(numBytesRemaining, numPaddingBits);
    }

    private static int decodeData(FileInputStream inputStream, FileOutputStream outputStream, HuffmanTree huffTree) throws IOException {
        int numDecodedBits = 0;
        SimpleEntry<Integer, Integer> metadata = getPaddingBitsAndFSize(inputStream);
        int numBytesRemaining = metadata.getKey();
        int numPaddingBits = metadata.getValue();

        byte nextByte;
        int bytesDecoded = 0;
        Node currentNode = huffTree.getRoot();

        while (inputStream.available() > 0 && bytesDecoded < numBytesRemaining - 1) {
            nextByte = (byte) inputStream.read();
            bytesDecoded++;
            for (int i = 7; i >= 0; i--) {
                if (bytesDecoded == numBytesRemaining - 1 && i < numPaddingBits) break;

                if (((nextByte >> i) & 1) == 1) {
                    currentNode = currentNode.getRight();
                } else {
                    currentNode = currentNode.getLeft();
                }

                if (currentNode.isLeaf()) {
                    outputStream.write(currentNode.getByteValue());
                    numDecodedBits += 8;
                    currentNode = huffTree.getRoot();
                }
            }
        }
        return numDecodedBits;
    }

    public static void compress(String inputFile, String outputFile, boolean verbose) throws IOException {
        DataInputStream inputStream = new DataInputStream(new FileInputStream(inputFile));
        DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(outputFile));
        System.out.println("Сжатие данных:");
        FreqTable freqTable = new FreqTable(inputFile);
        if (verbose) {
            freqTable.print();
            System.out.println();
        }

        HuffmanTree huffTree = new HuffmanTree(freqTable);
        if (verbose) {
            huffTree.print();
            System.out.println();
        }

        CodeMap codeMap = new CodeMap(huffTree.getRoot(), "");
        if (verbose) {
            codeMap.print();
            System.out.println();
        }

        // Write the header
        writeHeader(outputStream, freqTable);

        // Encode the data
        int numEncodedBits = encodeData(inputStream, outputStream, codeMap);

        inputStream.close();
        outputStream.close();

        System.out.println(inputFile + " -> " + outputFile);
        System.out.println(numEncodedBits + " бит закодировано\nИз которых " + (numEncodedBits % 8) + " в последнем байте\n");
    }

    public static void decompress(String inputFile, String outputFile, boolean verbose) throws IOException {
        FileInputStream inputStream = new FileInputStream(inputFile);
        FileOutputStream outputStream = new FileOutputStream(outputFile);
        System.out.println("Расшифровка:");
        FreqTable freqTable = readHeader(inputStream);
        if (verbose) {
            freqTable.print();
            System.out.println();
        }
        HuffmanTree huffTree = new HuffmanTree(freqTable);
        if (verbose) {
            huffTree.print();
            System.out.println();
        }
        CodeMap codeMap = new CodeMap(huffTree.getRoot(), "");
        if (verbose) {
            codeMap.print();
            System.out.println();
        }

        // Decode the data
        int numDecodedBits = decodeData(inputStream, outputStream, huffTree);

        inputStream.close();
        outputStream.close();

        System.out.println(inputFile + " -> " + outputFile);
        System.out.println(numDecodedBits + " бит было расшифровано!\n");
    }

    private static void writeHeader(DataOutputStream outputStream, FreqTable freqTable) throws IOException {
        Map<Byte, Integer> table = freqTable.getTable();
        outputStream.writeByte(table.size());
        for (Map.Entry<Byte, Integer> entry : table.entrySet()) {
            outputStream.writeByte(entry.getKey());
            outputStream.writeInt(entry.getValue());
        }
    }

    private static FreqTable readHeader(FileInputStream stream) throws IOException {
        DataInputStream inputStream = new DataInputStream(stream);
        Map<Byte, Integer> freqTable = new HashMap<>();
        int freqTableSize = inputStream.readByte();
        for (int i = 0; i < freqTableSize; i++) {
            byte c = inputStream.readByte();
            int freq = inputStream.readInt();
            freqTable.put(c, freq);
        }
        return new FreqTable(freqTable);
    }
}