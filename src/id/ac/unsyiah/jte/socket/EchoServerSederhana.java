/**
 * EchoServerSederhana.java Mar 29, 2014
 */
package id.ac.unsyiah.jte.socket;

/**
 * @author Al Qalit
 *
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerSederhana {
    public static void main(String[] args) throws Exception {

        //initialisasi port socket pada server
        int portSocket = 1805;
        // pembuatan  socket baru pada server
        ServerSocket serverSocket = new ServerSocket(portSocket);
        //Listening pada serversocket
        System.out.println("Listening on Port " + 
        			serverSocket.getLocalPort() +
        			" " + serverSocket.getInetAddress());
        
        //mencoba menerima socket dari client
        try {
        	Socket socketTerima = serverSocket.accept();
        	BufferedReader masuk = new BufferedReader(
        								new InputStreamReader(socketTerima.getInputStream()));
        	String strMasuk = masuk.readLine();
        	System.out.print("IP di Terima -> " + strMasuk);
        	if ( strMasuk == "127.0.0.2"){
        		System.out.print("IP di Tolak -> " + strMasuk);
        	}
        } finally {
        	//jika selesai loop tutup socket yang terbuka
        	serverSocket.close();
        }
        
    }
}