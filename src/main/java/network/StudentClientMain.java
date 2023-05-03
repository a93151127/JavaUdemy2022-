package network;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class StudentClientMain {
    public static void main(String[] args) {
        startClient();
    }

    public static void startClient(){
        try {
            Socket socket = new Socket("127.0.0.1", 8000);
            ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
            StudentAddress studentAddress =
                    new StudentAddress("Martin", "Xin", "Xin", "Taipei", "242");
            toServer.writeObject(studentAddress);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
