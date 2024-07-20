package Day20;
import java.io.*;
import java.net.Socket;

public class Task5Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(host, port);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            CalculationRequest request = new CalculationRequest(2, 2, "+");
            out.writeObject(request);

            CalculationResponse response = (CalculationResponse) in.readObject();
            System.out.println("Result: " + response.getResult());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
