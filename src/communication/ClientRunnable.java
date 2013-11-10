package communication;

import java.io.IOException;
import java.net.Socket;

public class ClientRunnable implements Runnable {
	
	private Socket clientSocket;

	public ClientRunnable(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	@Override
	public void run() {
		try {
			Communication.handleRequest(clientSocket);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
