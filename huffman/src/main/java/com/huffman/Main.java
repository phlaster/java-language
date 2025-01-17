package main.java.com.huffman;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Usage: java Main <flag> <file>");
            return;
        }

        String flag = args[0];
        String fileName = args[1];

        if (flag.equals("--encode")) {
            Huffman.compress(fileName, "output.bin", true);
        } else if (flag.equals("--decode")) {
            Huffman.decompress(fileName, "output.txt", true);
        } else {
            System.out.println("Invalid flag. Use --encode or --decode.");
        }
    }
}
