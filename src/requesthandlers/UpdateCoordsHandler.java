package requesthandlers;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramSocket;

public class UpdateCoordsHandler extends RequestHandler {

	@Override
	public void internalHandle(DatagramSocket socket, DataInputStream dis) {
		try {
			System.out.println("Name: " + dis.readUTF());
			System.out.println("Lat: " + dis.readDouble());
			System.out.println("Long: " + dis.readDouble());
			System.out.println("Alt: " + dis.readDouble());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
