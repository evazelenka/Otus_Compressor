package ru.otus.huffmancompress;

import ru.otus.rlecompress.ICompress;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class CompressHuffman implements ICompress {
    private int [] freqs = new int [256];

    @Override
    public String getName() {
        return "Huffman";
    }

    @Override
    public String getExt() {
        return ".huf";
    }

    @Override
    public void prepare(InputStream input) throws IOException{
        Arrays.fill(freqs, 0);
        int value;
        while(true){
            value = input.read();
            if(value == -1) break;
            freqs[value]++;
        }
    }

    @Override
    public void compress(InputStream input, OutputStream output) throws IOException {

    }

    @Override
    public void decompress(InputStream input, OutputStream output) throws IOException {

    }
}
