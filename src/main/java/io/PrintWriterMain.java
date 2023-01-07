package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriterMain {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/test/abc.txt");

        //創建檔案
        PrintWriter output = new PrintWriter(file);
        System.out.println("already build");
        //寫入數據
        output.print("aaaaaaaaaaaaaaaaaaa");
        output.println(10);
        System.out.println("already write");

        output.close();
    }
}
