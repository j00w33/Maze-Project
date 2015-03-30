package socket;

import java.io.IOException;
import java.net.Socket;

import maze.logic.LogFile;

/**
 * 
 * @author Andrew
 *Client class for project
 */
public class Client {
	
	
	public Client() {

		
		String serverName = "127.0.0.1";
		int port = 13000;
		try {
			LogFile.write("Connecting to " + serverName + " on port "
					+ port);
			Socket client = new Socket(serverName, port);
			LogFile.write("Just connected to "
					+ client.getRemoteSocketAddress());
			client.close();
		} catch (IOException e) {
			LogFile.write("IOException in Client, server not found");
		}
	}

}
