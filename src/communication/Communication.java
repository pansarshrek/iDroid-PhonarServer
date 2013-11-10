package communication;

import java.io.IOException;
import java.net.Socket;

import requesthandlers.RequestHandler;

public class Communication {
	
	public static final int COM_UPDATE_COORD = 0,
		COM_GET_COORDS = 1,
		COM_CREATE_GROUP = 2,
		COM_DISBAND_GROUP = 3,
		COM_ADD_USER = 4,
		COM_CREATE_USER = 5;
	
	public static void handleRequest(Socket s) throws IOException {
		int b = s.getInputStream().read();
		
		RequestHandler handler = null;
		
		// TODO intialize correct handler in case statements
		switch (b) {
		case COM_UPDATE_COORD:
			break;
		case COM_GET_COORDS:
			break;
		case COM_CREATE_GROUP:
			break;
		case COM_DISBAND_GROUP:
			break;
		case COM_ADD_USER:
			break;
		case COM_CREATE_USER:
			break;
		default:
			break;
		}
		
		handler.handleRequest();
	}

}
