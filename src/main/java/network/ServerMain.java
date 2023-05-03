package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    public static void main(String[] args) {
        startServer();
    }

    public static void startServer(){

        try {
            ServerSocket serverSocket = new ServerSocket(8001);
            Socket socket = serverSocket.accept();

            DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
            DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

            while(true){
                double radius = inputFromClient.readDouble();
                double area = radius*radius*Math.PI;

                outputToClient.writeDouble(area);
                System.out.println("Area is " + area + "and already sent");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
