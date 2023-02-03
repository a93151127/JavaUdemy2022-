package io.fileStream;

import java.io.*;
import java.util.Date;

public class ObjectStreamMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student s = new Student();

        try(
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("object.dat"))
                ){
            output.writeUTF("MARTIN");
            output.writeDouble(95.6);
            output.writeObject(new Date());
            output.writeObject(s);
        }

        try(
                ObjectInputStream input = new ObjectInputStream(new FileInputStream("object.dat"));
                ){
            System.out.println(input.readUTF());
            System.out.println(input.readDouble());
            System.out.println(input.readObject());
            System.out.println(input.readObject());
        }
    }
}
