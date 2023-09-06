package socketProgramming;

import java.io.*;
import java.net.*;

public class MainClient {
    public static void main(String[] args) throws IOException, URISyntaxException {
//        Socket socket = new Socket(InetAddress.getLocalHost(), 6665);
//
//        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
//
//        printWriter.println("hiii");
//        printWriter.flush();

        //URI uri = new URI("central3.satsport248.com:8881?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhZ2VudGlkIjoiaWNlZXhjaCIsImRhdGV0aW1lIjoxNjU3NjgxMzU5ODIzLCJpYXQiOjE2NTc2ODEzNTl9.J4uBf6x58y52DETKs7Xvzy9DhrSEOsi5k155UWKZQ_Y");
        URL url = new URL("");

        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

        urlConnection.setDoOutput(true);
        urlConnection.setDoInput(true);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        String inputLine;
        while ((inputLine = bufferedReader.readLine()) != null)
            System.out.println(inputLine);
        bufferedReader.close();
    }
}
