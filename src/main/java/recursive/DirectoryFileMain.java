package recursive;

import java.util.Scanner;
import java.io.File;

public class DirectoryFileMain {
    public static void main(String[] args) {
        System.out.println("Please Enter Directory");
        Scanner input = new Scanner(System.in);
        String directory = input.nextLine();

        System.out.println("Total :" + getSize(new File(directory)) + " bytes");
    }

    private static long getSize(File file){
        long size = 0;
        //終止條件: 判斷file是不是一個檔案,如果是則直接回傳
        if(file.isFile()){
            return file.length();
        }else{
            //取得file檔案夾裡面的列表
            File[] fileList = file.listFiles();
            for(int i = 0; i < fileList.length; i++){
                //System.out.println(fileList[i].getName());
                size += getSize(fileList[i]);
            }
        }
        return size;
    }
}
