/**
 * EchoServerSederhana.java Mar 29, 2014
 */
package id.ac.unsyiah.jte.socket;

/**
 * @author Al Qalit
 *
 */

import java.io.*;
import java.net.*;

public class EchoServerSederhana{
	private Socket socket = null;
	private ServerSocket server   = null;
	private DataInputStream streamIn =  null;

	public EchoServerSederhana(int port) {
       try {
         server = new ServerSocket(port);
         System.out.println("Listening on " + server.getLocalPort());
         socket = server.accept();
	     InetAddress client = InetAddress.getLocalHost();
         String ipClient= client.getHostAddress();
         open();
         System.out.println(ipClient + " Connect");
         boolean done = false;
         while (!done){
             try {
                 System.out.print("Client >> ");
                 String line = streamIn.readUTF();
                 System.out.println(line);
                 done = line.equals("stop!");
             }
             catch(IOException ioe) {
                 done = true;
             }
         }
         close();
       }
      catch(IOException ie) {
          System.out.println("IO excep");
      }
   }

   public void open() throws IOException {
       streamIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
   }
   public void close() throws IOException {
       if (socket != null)    socket.close();
       if (streamIn != null)  streamIn.close();
   }
   public static void main(String args[]) {
       EchoServerSederhana server = null;
       if (args.length != 1)
           System.out.println("Cara : <Program> <PORT>");
       else
           server = new EchoServerSederhana(Integer.parseInt(args[0]));
   }

}