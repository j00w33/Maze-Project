package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import maze.logic.LogFile;

/**
 * 
 * @author Andrew
 *Server class for Project
 */
public class Server extends Thread {

	// New ServerSocket
	private ServerSocket serverSocket;

	// Server constructor
	public Server(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(10000);
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
				LogFile.write("IOException in socket, cannot open port");
				break;
			} 
		}
	}
}
