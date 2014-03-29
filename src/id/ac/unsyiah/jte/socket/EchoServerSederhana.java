/**
 * EchoServerSederhana.java Mar 29, 2014
 */
package id.ac.unsyiah.jte.socket;

/**
 * @author Al Qalit
 *
 */

import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerSederhana {
    public static void main(String[] args) throws Exception {

        // pembuatan  socket baru pada server
        int portSocket = 1805;
        ServerSocket serverSocket = new ServerSocket(portSocket);
        System.out.println("Memulai  " + serverSocket);
        
        Socket scoketTerima = serverSocket.accept();
    }
}