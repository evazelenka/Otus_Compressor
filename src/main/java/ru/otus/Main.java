package ru.otus;//Основы сжатия данных: создаем RLE архиватор // Демо-занятие курса "Алгоритмы и структуры данных"

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String file = "Veb1\\demo.txt";
        ICompress alg = new CompressRLE();
        String fileZip = file + alg.getExt();
        String fileUnzip = file + ".copy";
        try {
            compress(alg, file, fileZip);decompress(alg,fileZip, fileUnzip);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void compress(ICompress alg, String file, String fileZip) throws IOException {
        try(FileInputStream input = new FileInputStream(file);
            FileOutputStream output = new FileOutputStream(fileZip)){
            alg.compress(input, output);
        }
    }

    private static void decompress(ICompress alg, String fileZip, String fileUnzip){

    }
}
