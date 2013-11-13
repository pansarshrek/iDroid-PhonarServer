package requesthandlers;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public abstract class RequestHandler {

	public void handleRequest(DatagramSocket socket, DatagramPacket packet) {
		// Offset 1 to get rid of first byte which determines the type of
		// request
		DataInputStream dis = new DataInputStream(new ByteArrayInputStream(
				packet.getData(), 1, packet.getLength()));
		internalHandle(socket, dis);
	}

	public abstract void internalHandle(DatagramSocket socket,
			DataInputStream dis);

}
