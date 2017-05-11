package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import model.Vibration;
import ws.OutputVibrate;

@Path("InputVibrate")
public class InputVibrate {

	OutputVibrate webSocket = null;
	
	@POST
	@Consumes("application/json")
	public void ReceivedVibrate(Vibration vibration){
		webSocket = OutputVibrate.getInstance();
		webSocket.sendToAll(vibration.toJson());
	}
	
}
