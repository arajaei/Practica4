import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer4 {

    
    private static final int PORT = 8180;
    

   
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket0=null;
        try {
            serverSocket0 = new ServerSocket(PORT);
        }
        catch (IOException e) {
            System.err.println("Could not listen on port: " + PORT);
            System.exit(1);
        }
        ServerSocket serverSocket1=null;
        try {
            serverSocket1 = new ServerSocket(8181);
        }
        catch (IOException e) {
            System.err.println("Could not listen on port: " + 8181);
            System.exit(1);
        }

        Socket clientSocket0=null;
        try {
            clientSocket0 = serverSocket0.accept();
            System.out.println("coneccion esta aceptada en el puerta numero  :"+ PORT); 
        }
        catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        Socket clientSocket1=null;
        try {
            clientSocket1 = serverSocket1.accept();
            System.out.println("coneccion esta aceptada en el puerta numero  :"+ 8181); 
        }
        catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

        PrintWriter out0 = new PrintWriter(clientSocket0.getOutputStream(), true);
        BufferedReader in0 = new BufferedReader(new InputStreamReader(clientSocket0.getInputStream()));
        PrintWriter out1 = new PrintWriter(clientSocket1.getOutputStream(), true);
        BufferedReader in1 = new BufferedReader(new InputStreamReader(clientSocket1.getInputStream()));

        System.out.println("Echo server started");

        String inputLine0;
        String inputLine1;
        int a=1;
        while (a==1) {
            
              inputLine0 = in0.readLine();  
              inputLine1 = in1.readLine();    
              System.out.println("echoing0: " + inputLine0);
              out0.println(inputLine0);
              System.out.println("echoing1: " + inputLine1);
              out1.println(inputLine1);
            
                      
        }
        out0.close();
        in0.close();
        clientSocket0.close();
        serverSocket0.close();
        out1.close();
        in1.close();
        clientSocket1.close();
        serverSocket1.close();
            
        

    }
}
