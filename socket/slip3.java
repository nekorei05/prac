//server side

import javax.swing.*;
import java.io.*;
import java.net.*;

public class ChatServer {
    private static JTextArea chatArea;
    private static JTextField inputField;
    private static PrintWriter out;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Server Chat");
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        inputField = new JTextField();
        frame.setLayout(new java.awt.BorderLayout());
        frame.add(new JScrollPane(chatArea), java.awt.BorderLayout.CENTER);
        frame.add(inputField, java.awt.BorderLayout.SOUTH);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        inputField.addActionListener(e -> {
            String msg = inputField.getText();
            chatArea.append("Server: " + msg + "\n");
            if (out != null) out.println(msg);
            inputField.setText("");
        });

        try (ServerSocket serverSocket = new ServerSocket(6000)) {
            chatArea.append("Server started. Waiting for client...\n");
            Socket socket = serverSocket.accept();
            chatArea.append("Client connected.\n");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            String msgFromClient;
            while ((msgFromClient = in.readLine()) != null) {
                chatArea.append("Client: " + msgFromClient + "\n");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

//client side

import javax.swing.*;
import java.io.*;
import java.net.*;

public class ChatClient {
    private static JTextArea chatArea;
    private static JTextField inputField;
    private static PrintWriter out;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Client Chat");
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        inputField = new JTextField();
        frame.setLayout(new java.awt.BorderLayout());
        frame.add(new JScrollPane(chatArea), java.awt.BorderLayout.CENTER);
        frame.add(inputField, java.awt.BorderLayout.SOUTH);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        inputField.addActionListener(e -> {
            String msg = inputField.getText();
            chatArea.append("Client: " + msg + "\n");
            if (out != null) out.println(msg);
            inputField.setText("");
        });

        try (Socket socket = new Socket("localhost", 6000)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            String msgFromServer;
            while ((msgFromServer = in.readLine()) != null) {
                chatArea.append("Server: " + msgFromServer + "\n");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}