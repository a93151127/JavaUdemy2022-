package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MultiClentMain {

    public static void main(String[] args) throws IOException {
        startClient();
    }

    public static void startClient() throws IOException {

            Socket socket = null;

            socket = new Socket("127.0.0.1", 8000);

            DataInputStream inputFromServer =
                    new DataInputStream(socket.getInputStream());
            DataOutputStream outputToServer =
                    new DataOutputStream(socket.getOutputStream());

            while (true){
                System.out.println("Please Enter Double Value : ");
                Scanner scanner = new Scanner(System.in);
                double radius = scanner.nextDouble();

                outputToServer.writeDouble(radius);
                outputToServer.flush();

                double area = inputFromServer.readDouble();
                System.out.println("Area : " + area);
                System.out.println("Local Port : " + socket.getLocalPort());
            }

    }
}
