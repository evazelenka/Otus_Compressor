package ru.otus;
//Основы сжатия данных: создаем RLE архиватор(run length encoding, кодирование длин серий)
//Демо-занятие курса "Алгоритмы и структуры данных"

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String file = "C:\\Users\\evaze\\OneDrive\\Desktop\\Otus\\Archiver\\demo.txt";
        ICompress alg = new CompressRLE();
        String fileZip = file + alg.getExt();
        String fileUnzip = file + ".copy";
        try {
            compress(alg, file, fileZip);
            decompress(alg,fileZip, fileUnzip);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void compress(ICompress alg, String file, String fileZip) throws IOException {
        System.out.println("compress using " + alg.getName());
        try(FileInputStream input = new FileInputStream(file);
            FileOutputStream output = new FileOutputStream(fileZip)){
            alg.compress(input, output);
        }
    }

    private static void decompress(ICompress alg, String fileZip, String fileUnzip) throws IOException {
        System.out.println("decompress using " + alg.getName());
        try(FileInputStream input = new FileInputStream(fileZip);
            FileOutputStream output = new FileOutputStream(fileUnzip)){
            alg.decompress(input, output);
        }
    }
}
