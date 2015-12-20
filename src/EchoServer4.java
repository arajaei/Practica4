import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Thread;

public class EchoServer4 extends Thread {

   public void run()
   {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8187);
        }
        catch (IOException e) {
            System.err.println("Could not listen on port: " + 8187);
            System.exit(1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
            System.out.println("coneccion esta aceptada en el puerta numero  :"+ 8187); 
        }
        catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("Echo server started");

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("echoing: " + inputLine);
            out.println(inputLine);
           
        }
       
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
       
   }

    public static void main(String[] args) throws Exception {
       
        int PORT = 8187;
        
        if(args.length ==1)
         {
              PORT= Integer.parseInt(args[0]);
          }
        if(args.length != 0 && args.length != 1)
         {
             System.out.println("You can use this function only with 0 or 1 orguments !!!!");
             
         }
      int i=0;
      for(i=0;i<3;i++)
       {
           (new  EchoServer4()).start();
           
       }
       
    }
}
