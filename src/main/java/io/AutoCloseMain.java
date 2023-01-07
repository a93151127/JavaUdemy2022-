package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class AutoCloseMain {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/test/score.txt");

        //使用try-with-resource新語法寫,可以不用把流close
        try(PrintWriter output = new PrintWriter(file)){
            output.print("aaaaaaaaaaaaaaaaaaa");
            output.println(10);
        }
    }
}
