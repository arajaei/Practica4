import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
  public static void main(String[] args) throws Exception {

    int Port=8187;
    String hostname = "localhost";
    if(args.length ==2)
        {
          Port = Integer.parseInt(args[0]);
          hostname=args[1];
        }
    
    if(args.length != 0 && args.length != 2)
        {
          System.out.println("You must enter 2 or enter without arguments !!!!!");
        }
    
    Socket theSocket = new Socket(hostname, Port);
    BufferedReader networkIn = new BufferedReader(new InputStreamReader(theSocket.getInputStream()));
    BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(theSocket.getOutputStream());
    System.out.println("Connected to echo server");

    while (true) {
      String theLine = userIn.readLine();
      if (theLine.equals("."))
        break;
      out.println(theLine);
      out.flush();
      System.out.println(networkIn.readLine());
    }
    networkIn.close();
    out.close();
  }
}
