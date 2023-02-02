package io.fileStream;

import java.io.*;

public class DataStreamMain {
    public static void main(String[] args) throws IOException {
        try(DataOutputStream dataOutput = new DataOutputStream(new FileOutputStream("temp.dat"))){
            dataOutput.writeUTF("martin");
            dataOutput.writeDouble(98.2);

            dataOutput.writeUTF("abi");
            dataOutput.writeDouble(95.0);

            dataOutput.writeUTF("wilson");
            dataOutput.writeDouble(84.2);
        }

        try(DataInputStream dataInput = new DataInputStream(new FileInputStream("temp.dat"))){
            System.out.println(dataInput.readUTF());
            System.out.println(dataInput.readDouble());

            System.out.println(dataInput.readUTF());
            System.out.println(dataInput.readDouble());

            System.out.println(dataInput.readUTF());
            System.out.println(dataInput.readDouble());
        }
    }
}
