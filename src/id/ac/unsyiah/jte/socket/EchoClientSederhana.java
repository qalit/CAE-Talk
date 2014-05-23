/**
 * EchoClientSederhana.java Mar 29, 2014
 */
package id.ac.unsyiah.jte.socket;

/**
 * @author Al Qalit
 *
 */
import java.io.*;
import java.net.*;


public class EchoClientSederhana {
	private Socket socket = null;
	private DataInputStream  console = null;
	private DataOutputStream streamOut = null;

    @SuppressWarnings("deprecation")
	public EchoClientSederhana(String serverName, int serverPort) {
		try {
            String server;
			String inIP = serverName;
            if (inIP.equalsIgnoreCase("127.0.0.1")) {
				System.out.println("[*] IP : " + inIP + " Diblok");
				System.exit(0);
            } else {
                socket = new Socket(serverName, serverPort);
                System.out.println("[*] Connected ke: " + socket.getInetAddress() + ":" + socket.getPort());

                start();
                System.out.println("[*] Memulai Percakapan");
                System.out.println("[**] Ketik 'end' untuk mengakhiri");
            }
        }
        catch(UnknownHostException hu) {
			System.out.println("Host Unknown " + hu.getMessage());
	    }

		catch(IOException ie) {
			System.out.println("Error: " + ie.getMessage()+ " atau kesalahan <PORT>");
	    }

		String line = "";
	    while (!line.equalsIgnoreCase("end")) {
	    	try {
	    		System.out.print("Pesan >> ");
                line = console.readLine();
	    		streamOut.writeUTF(line);
	    		streamOut.flush();
	       }
	       catch(IOException ioe) {
	    	   System.out.println("Sending error: " + ioe.getMessage());
	       }
	    }
    }

    public void start() throws IOException {
    	console   = new DataInputStream(System.in);
    	streamOut = new DataOutputStream(socket.getOutputStream());
    }

    public void stop(){
    	try {
    		if (console   != null)  console.close();
    		if (streamOut != null)  streamOut.close();
    		if (socket    != null)  socket.close();
        }
       	catch(IOException ioe) {
       		System.out.println("Error Menutup Aplikasi ...");
       }
    }

  public static void main(String args[]) {
      EchoClientSederhana client = null;
      if (args.length != 2)
         System.out.println("Cara: <Program> <HOST> <PORT>");
      else
         client = new EchoClientSederhana(args[0], Integer.parseInt(args[1]));
   }
 }