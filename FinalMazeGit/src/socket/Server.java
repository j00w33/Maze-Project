package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import maze.logic.LogFile;

/**
 * 
 * @author Andrew Server class for Project
 */
public class Server extends Thread {
	
	public final static int PORT = 13000;

	// New ServerSocket
	private ServerSocket serverSocket;

	// Server constructor
	public Server(int port) {
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.setSoTimeout(10000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LogFile.write("IO Exception cannot open socket");
		}
	}

	public void run() {
		while (true) {
			try {
				LogFile.write("Waiting for client on port "
						+ serverSocket.getLocalPort() + "...");
				Socket server = serverSocket.accept();
				LogFile.write("Just connected to "
						+ server.getRemoteSocketAddress());
				server.close();
			} catch (IOException s) {
				LogFile.write("IOException in Server, cannot open port / Or Timeout");
				break;
			}
		}
	}
}
