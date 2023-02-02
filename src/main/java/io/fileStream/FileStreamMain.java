package io.fileStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamMain {
    public static void main(String[] args) throws IOException {

        //使用try with resource因為會自動把"流"關閉
        try(FileOutputStream outputStream = new FileOutputStream("temp.dat")){
            for(int i = 1; i <= 10; i ++){
                outputStream.write(i);
            }
        }

        try(FileInputStream inputStream = new FileInputStream("temp.dat")){
            int value;
            while((value = inputStream.read()) != -1){
                System.out.println(value);
            }
        }
    }
}
