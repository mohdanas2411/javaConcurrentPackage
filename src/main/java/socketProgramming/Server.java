package socketProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
    public Server() throws IOException {
        ServerSocket server = new ServerSocket(62666);
        client = server.accept();
        new Thread(this).start();
    }

    public void run()
    {
        try
        {
            String message;
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            while((message=reader.readLine())!=null)
            {
                System.out.println("Message from client: "+message);
            }
        }catch(Exception e)
        {
            System.out.println("Client disconnected");
        }
    }
    Socket client;
}