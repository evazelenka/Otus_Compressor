package ru.otus;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CompressRLE implements ICompress{
    @Override
    public String getName() {
        return "RLE";
    }

    @Override
    public String getExt() {
        return ".rle";
    }

    @Override
    public void compress(InputStream input, OutputStream output) throws IOException {
        int prevByte = input.read();
        if(prevByte == -1) return;

        int count = 1;
        int currentByte;

        while(true){
            currentByte = input.read();
            if(currentByte == -1)
                break;
            if(currentByte == prevByte && count < 255)
                count++;
            else
            {
                output.write(prevByte);
//                output.write(String.valueOf(count).getBytes());
                output.write(count);
                prevByte = currentByte;
                count = 1;
                output.flush();
            }
        }
        output.write(prevByte);
//        output.write(String.valueOf(count).getBytes());
        output.write(count);
        output.flush();
    }

    @Override
    public void decompress(InputStream input, OutputStream output) throws IOException {
        int value;
        int count;
        while(true){
            value = input.read(); if(value == -1) break;
            count = input.read();
            for (int i = 0; i < count; i++)
                output.write(value);
        }
    }
}
