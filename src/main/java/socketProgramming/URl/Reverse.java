package socketProgramming.URl;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.WebSocket;

public class Reverse {
    public static void main(String[] args) throws Exception {


        SSLSocketFactory factory =
                (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket socket =
                (SSLSocket) factory.createSocket("central3.satsport248.com", 8881);


        URL url = new URL("https://central3.satsport248.com:8881?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhZ2VudGlkIjoiaWNlZXhjaCIsImRhdGV0aW1lIjoxNjU3NjgxMzU5ODIzLCJpYXQiOjE2NTc2ODEzNTl9.J4uBf6x58y52DETKs7Xvzy9DhrSEOsi5k155UWKZQ_Y");
        // socket.setSSLParameters();
        // ;
        PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream())));


        out.println("GET / HTTP/1.0");
        out.println("Content-Type: text/html\r\n\r\n");
      //  out.println("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhZ2VudGlkIjoiaWNlZXhjaCIsImRhdGV0aW1lIjoxNjU3NjgxMzU5ODIzLCJpYXQiOjE2NTc2ODEzNTl9.J4uBf6x58y52DETKs7Xvzy9DhrSEOsi5k155UWKZQ_Y");
        out.println(url);
        out.println("{\"action\":\"set\", \"markets\":\"2264347\"}");
        socket.startHandshake();
        out.flush();
        if (out.checkError())
            System.out.println(
                    "SSLSocketClient:  java.io.PrintWriter error");

        /* read response */
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {

            System.out.println(inputLine);
        }

        in.close();
        out.close();
        socket.close();
    }
}