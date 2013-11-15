package requesthandlers;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramSocket;

import exceptions.UserExistsException;

import models.Position;
import models.UserDatabase;

public class CreateUserHandler extends RequestHandler {

	@Override
	public void internalHandle(DatagramSocket socket, DataInputStream dis) {
		try {
			String name = dis.readUTF();
			Position pos = new Position(dis);
			
			UserDatabase.addUser(name, pos);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UserExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}



}
