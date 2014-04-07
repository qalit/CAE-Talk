/**
 * EchoServerSederhana.java Mar 29, 2014
 */
package id.ac.unsyiah.jte.socket;

/**
 * @author Al Qalit
 *
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServerSederhana {
	public static int portSocketDefault = 1805; //berdasarkan 2 NIM belakang mahasiswa
	private static ServerSocket serverSocket;
	
	public static void main(String[] args) throws Exception {
		// pembuatan  socket baru pada server
		try {
		serverSocket = new ServerSocket(portSocketDefault);
        //Listening pada serversocket
        System.out.println("Listening on Port " + 
        			serverSocket.getLocalPort());
		} catch(SocketException e) {
			System.out.println("Error attach port!");
			System.exit(1);
		} catch(IOException e){
			System.out.println("Error binding socket!");
			System.exit(1);
		}
		/*perform the echo service indefinitely*/
		do {
			mulai();
		} while (true);	}
	
	private static void mulai() throws IOException {
		/*data socket*/
		//Socket sock = null;
		try {
			/*listen for incoming connections*/
			Socket socket = serverSocket.accept();
			try{
			BufferedReader in = new BufferedReader(
									new InputStreamReader(socket.getInputStream()));
			/*create the socket writer */
			PrintWriter out = new PrintWriter(new BufferedWriter( 
									new OutputStreamWriter(socket.getOutputStream())),true);
			/*read from the data socket*/
			while (true){
				InetAddress addBlock = socket.getInetAddress();//buat IP yg di block
				
				String str = in.readLine();
				
				if(str.equals("END")) break;
				System.out.println("Echo: " + str);
				out.println(str);
			}
		} finally {
		/*close the socket*/
			serverSocket.close();
		}}finally{
			
		}
	}
}