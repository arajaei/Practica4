import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer5 extends Thread {

        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        
  
   public EchoServer5(ServerSocket  a,Socket  b)
   {
       serverSocket=a;
       
       clientSocket=b;
   }
   
   public void run()
   {
       PrintWriter out=null;
       BufferedReader in=null;
       try{
          out = new PrintWriter(clientSocket.getOutputStream(), true);
       }catch(IOException e)
       {
          System.out.println("can't creat printwriter  out"); 
       }
       try{
          in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
       }catch(IOException e){
       
          System.out.println("can't creat BufferReader  in"); 
       }
       
       System.out.println("Echo server started");
       
        String inputLine;
       try{
        while ((inputLine = in.readLine()) != null) {
            System.out.println("echoing: " + inputLine);
            out.println(inputLine);
        }
       }catch(IOException e){
           System.out.println("jkhdkas");
       }
        out.close();
        in.close();
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
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        EchoServer5 hilo;
        int i=1;
      
        try {
            serverSocket = new ServerSocket(PORT);
        }
        catch (IOException e) {
            System.err.println("Could not listen on port: " + PORT);
            System.exit(1);
        }

        while(i==1)
        {

        try {
            clientSocket = serverSocket.accept();
            System.out.println("coneccion esta aceptada en el puerta numero  :"+ PORT); 
        }
        catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

          hilo=new EchoServer5(serverSocket,clientSocket);
          hilo.start();
       
       
        }//while
   
        

       
       
        clientSocket.close();
        serverSocket.close();
    }
}
