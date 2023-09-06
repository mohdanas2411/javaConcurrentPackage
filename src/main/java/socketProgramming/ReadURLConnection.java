package socketProgramming;


import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.Certificate;
import java.io.*;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

public class ReadURLConnection {
        public static void main(String[] args)
        {
            new ReadURLConnection().testIt();
        }

        private void testIt(){

            String https_url = "https://central3.satsport248.com:8881?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhZ2VudGlkIjoiaWNlZXhjaCIsImRhdGV0aW1lIjoxNjU3NjgxMzU5ODIzLCJpYXQiOjE2NTc2ODEzNTl9.J4uBf6x58y52DETKs7Xvzy9DhrSEOsi5k155UWKZQ_Y";
            URL url;
            try {

                url = new URL(https_url);
                HttpsURLConnection con = (HttpsURLConnection)url.openConnection();


                //dumpl all cert info
                print_https_cert(con);

                //dump all the content
                print_content(con);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        private void print_https_cert(HttpsURLConnection con){

            if(con!=null){

                try {

                    System.out.println("Response Code : " + con.getResponseCode());
                    System.out.println("Cipher Suite : " + con.getCipherSuite());

                    System.out.println("\n");

                    Certificate[] certs = con.getServerCertificates();
                    for(Certificate cert : certs){
                        System.out.println("Cert Type : " + cert.getType());
                        System.out.println("Cert Hash Code : " + cert.hashCode());
                        System.out.println("Cert Public Key Algorithm : "
                                + cert.getPublicKey().getAlgorithm());
                        System.out.println("Cert Public Key Format : "
                                + cert.getPublicKey().getFormat());
                        System.out.println("\n");
                    }

                } catch (SSLPeerUnverifiedException e) {
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                }

            }

        }

        private void print_content(HttpsURLConnection con){
            if(con!=null){



            }

        }

    }
