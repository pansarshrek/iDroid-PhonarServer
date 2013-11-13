package communication;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

	private static final int DEFAULT_PORT = 13337;
	private ServerSocket ss;
	
	public Server(int port) throws IOException {
		ss = new ServerSocket(port);
	}
	
	public static void main(String[] args) {
		int port = DEFAULT_PORT;
		if (args.length >= 1) {
			port = Integer.parseInt(args[0]);
		}
		
		try {
			Server server = new Server(port);
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("\n\nFailed to start server on port: " + port);
		}
		
	}

	private void start() {
		while (true) {
			try {
				Thread t = new Thread(new ClientRunnable(ss.accept()));
				t.start();
				System.out.println("Some asshole connected");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
