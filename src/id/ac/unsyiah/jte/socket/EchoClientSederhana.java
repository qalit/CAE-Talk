/**
 * EchoClientSederhana.java Mar 29, 2014
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
import java.net.Socket;

public class EchoClientSederhana {
	public static void main(String[] args) throws IOException {
		
		InetAddress addr = InetAddress.getLocalHost();
		int portSocketDefault = 1805;

		System.out.println("addr = " + addr);
		Socket socket = new Socket(addr, portSocketDefault);
		try {
			System.out.println ("socket = " + socket.getInetAddress());
			BufferedReader in = new BufferedReader (
						new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(socket.getOutputStream())),true);
			// tulis sesuatu
			for(int i = 0; i < 10; i++){
				out.println("Hallo " + i);
				String str = in.readLine();
				System.out.println(str);
			} out.println("END");
		} finally {
		socket.close();
		}
	}
}

