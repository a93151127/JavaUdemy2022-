package io.fileStream;



import java.io.*;

public class EndOfFileMain {
    public static void main(String[] args) {
        try{
            try(DataOutputStream output = new DataOutputStream(new FileOutputStream("test.dat"))){
                output.writeDouble(34.5);
                output.writeDouble(32.1);
                output.writeDouble(15.5);
            }

            try(DataInputStream input = new DataInputStream(new FileInputStream("test.dat"))){
                while(true){
                    System.out.println(input.readDouble());
                }
            }
        } catch (EOFException e) {
            System.out.println("this is the end of file!");
            System.out.println("this is the end of file!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
