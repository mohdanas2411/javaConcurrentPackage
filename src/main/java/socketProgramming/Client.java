package socketProgramming;

import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class Client {
    public Client()
    {
        try
        {
            URL url = new URL("http://127.0.0.1:62666");
            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            PrintWriter writer = new PrintWriter(urlConnection.getOutputStream());

            System.out.println(
                    "client"
            );
            writer.println("Hello World!");
            writer.flush();
            writer.close();
        }catch(Exception e){e.printStackTrace();}
    }
}