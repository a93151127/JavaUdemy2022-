package io.fileStream;

import java.io.*;

public class SerializingArrayMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int[] intArray = {1,2,3,4,5};
        String[] sArray = {"martin", "abi", "welson"};

        try(
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("array.dat"));
                ){
            output.writeObject(intArray);
            output.writeObject(sArray);
        }

        try(
                ObjectInputStream input = new ObjectInputStream(new FileInputStream("array.dat"));
                ){
            int[] a = (int[]) input.readObject();
            String[] s = (String[]) input.readObject();

            for(int i = 0; i < a.length; i++){
                System.out.println(a[i]);
            }
            for(int j = 0; j < s.length; j++){
                System.out.println(s[j]);
            }
        }
    }
}
