import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer2 {

   

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
        
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        PrintWriter out=null;
        BufferedReader in=null;
        int i=1;
       
      
        while(i==1)
        {

        try {
            serverSocket = new ServerSocket(PORT);
        }
        catch (IOException e) {
            System.err.println("Could not listen on port: " + PORT);
            System.exit(1);
        }
   
        try {
            clientSocket = serverSocket.accept();
            System.out.println("coneccion esta aceptada en el puerta numero  :"+ PORT); 
        }
        catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("Echo server started");

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("echoing: " + inputLine);
            out.println(inputLine);
                      
            
        }
        serverSocket.close();
        clientSocket.close();
            
        }//while
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
