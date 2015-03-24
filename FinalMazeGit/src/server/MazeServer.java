package server;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * 
 * @author Andrew
 *This class was created by Andrew
 */
public class MazeServer {
	private ServerSocket serverSocket;
	
	// server constructor on parsed port
	public MazeServer(int port) throws IOException {
		serverSocket = new ServerSocket(port); // starts a new socket on parsed port
		serverSocket.setSoTimeout(10000); // set the socket to timeout after 10000 ms
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
