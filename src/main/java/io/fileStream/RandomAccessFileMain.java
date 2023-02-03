package io.fileStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileMain {
    public static void main(String[] args) throws IOException {

        try(
                RandomAccessFile raf = new RandomAccessFile("test.dat", "rw");
                ){
            //讀取文件裡面有多少字節
            System.out.println(raf.length());
            //清空文件(留下多少字節)
            raf.setLength(0);
            System.out.println(raf.length());
            //寫入數據(一個int為4個字節bytes)
            for(int i =1; i<=10; i++){
                //從頭開始替換並寫入字節
                raf.writeInt(i);
            }
            System.out.println(raf.length());
            //將指針放在某個位置(這邊是放在第0個字節)
            raf.seek(0);
            System.out.println("this num is : " + raf.readInt());
            //將指針放到最後面,並且加入數字135
            raf.seek(raf.length());
            raf.writeInt(135);
            raf.seek(40);
            System.out.println("the last number : " + raf.readInt());
        }

    }
}
