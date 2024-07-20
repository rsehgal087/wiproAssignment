package Day20;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Task5Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is listening on port 12345");

            while (true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

            CalculationRequest request = (CalculationRequest) in.readObject();
            int result = performCalculation(request);
            out.writeObject(new CalculationResponse(result));

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private int performCalculation(CalculationRequest request) {
        switch (request.getOperation()) {
            case "+":
                return request.getNumber1() + request.getNumber2();
            case "-":
                return request.getNumber1() - request.getNumber2();
            case "*":
                return request.getNumber1() * request.getNumber2();
            case "/":
                return request.getNumber1() / request.getNumber2();
            default:
                throw new IllegalArgumentException("Unknown operation: " + request.getOperation());
        }
    }
}

class CalculationRequest implements Serializable {
    private int number1;
    private int number2;
    private String operation;

    public CalculationRequest(int number1, int number2, String operation) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public String getOperation() {
        return operation;
    }
}

class CalculationResponse implements Serializable {
    private int result;

    public CalculationResponse(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }
}
