package requesthandlers;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramSocket;

public class CreateUserHandler extends RequestHandler {

	@Override
	public void internalHandle(DatagramSocket socket, DataInputStream dis) {
		try {
			System.out.println(dis.readUTF());
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}



}
