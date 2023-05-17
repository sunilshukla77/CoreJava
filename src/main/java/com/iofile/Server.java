package com.iofile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    ServerSocket serverSocket;
    Socket socket;

    BufferedReader bufferedReader;
    PrintWriter printWriter;

    public Server() {
        try {
            serverSocket = new ServerSocket(7777);
            System.out.println("Server is ready to accept connection....");
            System.out.println("Waiting for client............");
            socket = serverSocket.accept();
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream());
            startReading();
            startWriting();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void startWriting() {
        //thread - ata user se lega and then send karega client tak
        Runnable r2 = () -> {
            System.out.println("Writer started...");
            try {
                while (!socket.isClosed()) {
                    BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
                    String content = br2.readLine();
                    printWriter.println(content);
                    printWriter.flush();
                    if(content.equals("exit")) {
                        socket.close();
                        System.out.println("Connection closed");
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Connection is Closed");
            }

        };
        new Thread(r2).start();
    }

    private void startReading() {
        //thread-1 - read karke deta rahegaa
        Runnable r1 = () -> {
            System.out.println("Reader started...");
            try {
                while (!socket.isClosed()) {

                    String msg = bufferedReader.readLine();
                    if (msg.equals("exit")) {
                        System.out.println("Client terminated the chat");
                        break;
                    }
                    System.out.println("Cleint :" + msg);


                }
            } catch (IOException e) {
                System.out.println("Connection is Closed");
            }

        };
        new Thread(r1).start();
    }

    public static void main(String[] args) {
        System.out.println("Running Server");
        new Server();
    }
}



