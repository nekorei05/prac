// server side

import java.io.*;
import java.net.*;

public class PrimeServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(5000)) {
            System.out.println("Server started. Waiting for client...");
            Socket socket = server.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String input;
            while ((input = in.readLine()) != null) {
                int num = Integer.parseInt(input);
                boolean isPrime = true;
                if (num < 2) isPrime = false;
                else {
                    for (int i = 2; i <= Math.sqrt(num); i++) {
                        if (num % i == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                }
                out.println(num + (isPrime ? " is Prime." : " is Not Prime."));
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
// client side


import java.io.*;
import java.net.*;
import java.util.Scanner;

public class PrimeClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter number to check prime (type 'exit' to quit): ");
            String input;
            while (!(input = sc.nextLine()).equalsIgnoreCase("exit")) {
                out.println(input);
                System.out.println("Server: " + in.readLine());
                System.out.println("Enter number to check prime (type 'exit' to quit): ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}