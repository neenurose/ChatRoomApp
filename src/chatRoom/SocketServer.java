/**
 * 
 */
package chatRoom;

/**
 * @author Neenu Vincent
 *
 */
import java.net.*;
import java.io.*;
public class SocketServer extends Thread {
	private ServerSocket serverSocket;
	public SocketServer(int port) throws IOException{
		serverSocket = new ServerSocket(port);
		//serverSocket.setSoTimeout(10000);
	}
	public void run() {
		BufferedReader in = null;
		PrintWriter out = null;
		System.out.println("Listening...");
		Socket clientSocket = null;
		try {
			clientSocket = serverSocket.accept();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        System.out.println("Accepted.");
		while(true) {
		      try {
		         
		         in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				 out = new PrintWriter(clientSocket.getOutputStream(),true);
				 String client_message = in.readLine();
				 System.out.println("Message from Client "+clientSocket.getInetAddress()+": "+client_message);
		         out.println(client_message);
		         
                 
		         if(client_message.equalsIgnoreCase("Bye")) {
		        	 clientSocket.close();
		        	 break;
		         }
		         
		         
		      }catch(SocketTimeoutException s) {
		         System.out.println("Socket timed out!");
		         break;
		      }catch(IOException e) {
		         e.printStackTrace();
		         break;
		      }
		   }
		   
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				int port = 1011;
				   try {
				      Thread t = new SocketServer(port);
				      t.start();
				   }catch(IOException e) {
				      e.printStackTrace();
				   }

	}


}

