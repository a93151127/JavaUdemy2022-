package io;

import java.io.File;

public class FileMain {
    public static void main(String[] args) {
        //使用相對路徑文件名較好
        File file = new File("src/test/TestFile.txt");
        System.out.println("Dose it exist ? " + file.exists());
        System.out.println("the file is " + file.length() + " bytes");
        System.out.println("Does it can be read ? " + file.canRead());
        //是否是個目錄
        System.out.println("Does it is Directory ? " + file.isDirectory());
        //是否使用絕對路徑名
        System.out.println("Does it absolut ? " + file.isAbsolute());
    }
}
