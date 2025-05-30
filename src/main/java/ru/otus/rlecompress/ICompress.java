package ru.otus.rlecompress;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface ICompress {
    String getName();
    String getExt();
    default void prepare(InputStream input) throws IOException{}
    public void compress(InputStream input, OutputStream output) throws IOException;
    public void decompress(InputStream input, OutputStream output) throws IOException;

}
