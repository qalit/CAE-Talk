/**
 * EchoServerSederhana.java Mar 29, 2014
 */
//package id.ac.unsyiah.jte.socket;

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
	private static Socket socket;
	
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
//		do {
//			mulai();
//		} while (true);	}
//	
//	@SuppressWarnings("null")
//	private static void mulai() throws IOException {
		/*data socket*/
		Socket sock = null;
		String blockIP = " <- Block";
		String noBlockIP = " <- Not Block";
		try {
			socket = serverSocket.accept();
//			try{
			BufferedReader in = new BufferedReader(
									new InputStreamReader(socket.getInputStream()));
			/*create the socket writer */
			PrintWriter out = new PrintWriter(new BufferedWriter( 
									new OutputStreamWriter(socket.getOutputStream())),true);
			/*read from the data socket*/
			if(socket.getLocalAddress() == socket.getInetAddress()){
				
				//String str = in.readLine();
				System.out.println("[*]"+ socket.getInetAddress() + blockIP);
				out.println("[-] IP anda di Block");
			}else{
//			while (true){
				
				String str = in.readLine();
				if(str.equals("END")); //break;
				System.out.println("[*] IP : "+ socket.getInetAddress() + noBlockIP);
				out.println("[-] IP " + socket.getInetAddress() + " Diterima");
			}
		} finally {
		/*close the socket*/
			sock.close();
//		}}finally{
			
		}
	}
}