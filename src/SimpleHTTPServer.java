import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SimpleHTTPServer {
    public static void main(String[] args) throws IOException {
        final ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080 ....");

        while (true) {
            try (Socket clientSocket = server.accept()) {
                Date today = new Date();
                String response = "HTTP/1.1 200 OK\r\n\r\n" + today;
                clientSocket.getOutputStream().write(response.getBytes("UTF-8"));
            }
        }
    }
}
