package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class StudentServerMain {
    static ObjectInputStream fromClient;
    public static void main(String[] args) {
        start();
    }

    public static void start(){
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server Start...");
            while (true){
                Socket socket = serverSocket.accept();
                fromClient = new ObjectInputStream(socket.getInputStream());
                Object object = fromClient.readObject();
                System.out.println("Object : " + object.toString());
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fromClient.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
