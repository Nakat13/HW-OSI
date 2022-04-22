import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Client {

    public static void main(String[] args) throws UnknownHostException {

        String lockalhost = "127.0.0.1";
        int port = 8081;
        try (Socket clientSocket = new Socket(lockalhost, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            System.out.println("New connection accepted");
            out.println("GET / HTTP/1.1\n");
            String resp = in.readLine();
            System.out.println(resp);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
