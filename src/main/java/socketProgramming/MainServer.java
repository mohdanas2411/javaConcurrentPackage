package socketProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class MainServer {
    public static void main(String[] args) throws IOException {
//        ServerSocket serverSocket = new ServerSocket(6665);
//
//        Socket accept = serverSocket.accept();
//
//        InputStreamReader inputStreamReader = new InputStreamReader(accept.getInputStream());
//
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//
//        System.out.println(bufferedReader.readLine());


        URL url = new URL("wss://central3.satsport248.com:8881?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhZ2VudGlkIjoiaWNlZXhjaCIsImRhdGV0aW1lIjoxNjU3NjgxMzU5ODIzLCJpYXQiOjE2NTc2ODEzNTl9.J4uBf6x58y52DETKs7Xvzy9DhrSEOsi5k155UWKZQ_Y");

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.setDoInput(true);
        InputStream inputStream = url.openStream();

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        bufferedReader.readLine();


    }
}
