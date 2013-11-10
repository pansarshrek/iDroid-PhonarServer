package requesthandlers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public abstract class RequestHandler {

	private DataOutputStream dos;
	private DataInputStream dis;
	
	public RequestHandler(Socket s) throws IOException {
		dos = new DataOutputStream(s.getOutputStream());
		dis = new DataInputStream(s.getInputStream());
	}
	
	public abstract void handleRequest();
	
}
