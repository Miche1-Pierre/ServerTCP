import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket serverSocket = new ServerSocket(8585);
            System.out.println("Serveur en attente...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Connexion établie avec le client");

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            System.out.println(reader.readLine());
            writer.println("Bien reçu !");

            reader.close();
            writer.close();
            clientSocket.close();
            serverSocket.close();
        }
        catch (Exception e) {
            System.err.println("[ERREUR] : " + e);
        }
    }
}