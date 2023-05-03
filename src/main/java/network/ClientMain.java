package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientMain {
    public static void main(String[] args) {
        startClient();
    }

    public static void startClient(){
        try {
            Socket socket = new Socket("127.0.0.1", 8001);

            DataInputStream fromServer = new DataInputStream(socket.getInputStream());
            DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());

            double radius = 5.0;
            toServer.writeDouble(radius);
            double area = fromServer.readDouble();

            //知道client端的port號是多少
            System.out.println("local port : " + socket.getLocalPort());
            System.out.println("Area From Server is : " + area);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
