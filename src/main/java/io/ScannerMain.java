package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerMain {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/test/TestFile.txt");

        if(file.exists()){
            Scanner scanner = new Scanner(file);

            while(scanner.hasNext()){
                System.out.print(scanner.next());
            }

            scanner.close();
        }
    }
}
