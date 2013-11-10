package communication;

import java.io.IOException;
import java.net.Socket;

import requesthandlers.AddUserHandler;
import requesthandlers.CreateGroupHandler;
import requesthandlers.CreateUserHandler;
import requesthandlers.DisbandGroupHandler;
import requesthandlers.GetCoordsHandler;
import requesthandlers.NoHandler;
import requesthandlers.RequestHandler;
import requesthandlers.UpdateCoordsHandler;

public class Communication {
	
	public static final int COM_UPDATE_COORD = 0,
		COM_GET_COORDS = 1,
		COM_CREATE_GROUP = 2,
		COM_DISBAND_GROUP = 3,
		COM_ADD_USER = 4,
		COM_CREATE_USER = 5,
		ANS_SUCCESS = 6,		// ex: success to create group
		ANS_FAILURE = 7,		// ex: failed to create user
		ANS_GET_COORDS = 8;		// contains data for COM_GET_COORDS request
	
	public static void handleRequest(Socket s) throws IOException {
		int b = s.getInputStream().read();
		
		RequestHandler handler = null;
	
		switch (b) {
		case COM_UPDATE_COORD:
			handler = new UpdateCoordsHandler(s);
			break;
		case COM_GET_COORDS:
			handler = new GetCoordsHandler(s);
			break;
		case COM_CREATE_GROUP:
			handler = new CreateGroupHandler(s);
			break;
		case COM_DISBAND_GROUP:
			handler = new DisbandGroupHandler(s);
			break;
		case COM_ADD_USER:
			handler = new AddUserHandler(s);
			break;
		case COM_CREATE_USER:
			handler = new CreateUserHandler(s);
			break;
		default:
			handler = new NoHandler(s);
			break;
		}
		
		handler.handleRequest();
	}

}
