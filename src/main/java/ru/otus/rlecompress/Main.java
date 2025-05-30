package ru.otus.rlecompress;
//Основы сжатия данных: создаем RLE архиватор(run length encoding, кодирование длин серий)
//Демо-занятие курса "Алгоритмы и структуры данных"

import java.io.File;
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
        long fileLength = new File(file).length();
        long startTime = System.currentTimeMillis();
        try(FileInputStream input = new FileInputStream(file);
            FileOutputStream output = new FileOutputStream(fileZip)){
            alg.compress(input, output);
        }

        long finishTime = System.currentTimeMillis();
        long fileZipLength = new File(fileZip).length();

        double compressRatio = (double) fileZipLength / fileLength * 100;

        System.out.println("Original size: " + fileLength);
        System.out.println("Compress size: " + fileZipLength);
        System.out.println(String.format("Ratio: %.2f%%%n", compressRatio));
        System.out.println("Time: " + (finishTime - startTime) + " ms");
    }

    private static void decompress(ICompress alg, String fileZip, String fileUnzip) throws IOException {
        System.out.println("decompress using " + alg.getName());
        long fileZipLength = new File(fileZip).length();
        long startTime = System.currentTimeMillis();
        try(FileInputStream input = new FileInputStream(fileZip);
            FileOutputStream output = new FileOutputStream(fileUnzip)){
            alg.decompress(input, output);
        }
        long finishTime = System.currentTimeMillis();
        long fileUnzipLength = new File(fileUnzip).length();

        System.out.println("Zip size: " + fileZipLength);
        System.out.println("Unzip size: " + fileUnzipLength);
        System.out.println("Time: " + (finishTime - startTime) + " ms");
    }
}
