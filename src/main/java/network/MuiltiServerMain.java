package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MuiltiServerMain {

    public static void main(String[] args) {
        new MuiltiServerMain().start();
    }

    private int clientNo  = 0;

    public void start(){
        new Thread(()->{
            try {
                ServerSocket serverSocket = new ServerSocket(8000);

                while (true){
                    Socket socket = serverSocket.accept();

                    clientNo++;
                    System.out.println("Number of Client : " + clientNo);

                    InetAddress inetAddress = socket.getInetAddress();

                    System.out.println("Address : " + inetAddress.getHostAddress());
                    System.out.println("HostName : " + inetAddress.getHostName());

                    new Thread(new HandleClients(socket)).start();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}

class HandleClients implements Runnable{

    private Socket socket;

    public HandleClients(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream inputFromClient =
                    new DataInputStream(socket.getInputStream());
            DataOutputStream outputToClient =
                    new DataOutputStream(socket.getOutputStream());

            while(true){
                double radius = inputFromClient.readDouble();
                double area = radius*radius*Math.PI;

                outputToClient.writeDouble(area);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}