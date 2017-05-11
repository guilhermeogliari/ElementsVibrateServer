package ws;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import model.Device;

@Stateless
@ServerEndpoint("/ws")
public class OutputVibrate {
	
	private static OutputVibrate instance = null;
	
	private static final Logger log = Logger.getLogger(OutputVibrate.class.getName() );
	private static List<Device> devices = Collections.synchronizedList(new ArrayList<Device>());
	
	public OutputVibrate() {}
	
	@OnMessage
	public void onMessage(Session session, String jsonMessage) {
		log.log(Level.INFO, "message: "+jsonMessage);
	}

	@OnOpen
	public void onOpen(Session session) {
		log.log(Level.INFO, "onOpen");
		Device device = new Device();
		device.setSession(session);
		devices.add(device);
	}
	
	@OnClose
	public void onClose(Session session) {
		log.log(Level.INFO, "onClose");
	}
	
	public static OutputVibrate getInstance(){
		if(instance == null){
			instance = new OutputVibrate();
		}
		return instance;
	}
	
	public void sendToAll(String message){		
		try{
			synchronized (devices) {
				for (Device device : devices) {
					device.getSession().getBasicRemote().sendText(message);
				}
			}
		}catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public Device findDevice(Session session){
		Device device = null;
		for (Device d : devices){
			String idSession = d.getSession().getId();
			if(idSession.equals(session.getId())){
				device = d;
			}
		}
		return device;
	}
	
}
