package socketPackage;

import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    Socket socket;

     Server(Socket socket) {
         this.socket=socket;
    }

    public static void main(String[] args) throws Exception {

        int port = 7777;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Listening on " + serverSocket.getLocalPort());

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Connected");
            new Thread(new Server(socket)).start();
        }
    }

    @Override
    public void run() {

    }
}
