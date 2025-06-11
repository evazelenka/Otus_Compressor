package ru.otus.huffmancompress;

import ru.otus.rlecompress.ICompress;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class CompressHuffman implements ICompress {
    private int [] freqs;

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
        freqs = new int[256];
        int value;
        while(true){
            value = input.read();
            if(value == -1) break;
            freqs[value]++;
        }
    }

    @Override
    public void compress(InputStream input, OutputStream output) throws IOException {
        for (int i = 0; i < 256; i++) {
            output.write(freqs[i]);
            Node root = buidTree();
            
        }
    }
    
    private Node buildTree(){
        OrderedPriorityQueue q = new OrderedPriorityQueue();

        for (int i = 0; i < ; i++) {
            
        }
    }

    @Override
    public void decompress(InputStream input, OutputStream output) throws IOException
    {
        freqs = new int[256];
        for (int i = 0; i <256 ; i++) {
            freqs[i] = input.read();
        }
        Node root = buildTree();
        BitReader reader = new
    }
}
