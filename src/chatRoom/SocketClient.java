/**
 * 
 */
package chatRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Neenu Vincent
 *
 */
public class SocketClient {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String serverName = "localhost";
		int port = 1011;
		BufferedReader in = null;
		PrintWriter out = null;
		BufferedReader buff_reader = new BufferedReader(new InputStreamReader(System.in));
		   try {
		      System.out.println("Connecting to server...");
		      Socket client = new Socket(serverName, port);
		      while(true) {
		    	  in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				  out = new PrintWriter(client.getOutputStream(),true);
			     
	              String message = buff_reader.readLine();
	              System.out.println(message);
			      out.println(message);
			      
			      String server_message = in.readLine();
			      System.out.println("Message from Server: " +server_message);
			      if(server_message.equalsIgnoreCase("Bye")) {
			    	  break;
			      }
		      }
		      client.close();
		   }catch(IOException e) {
		      e.printStackTrace();
		   }

	}

}
