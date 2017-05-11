package model;

import javax.websocket.Session;

public class Device {

	private Long id;
	private String name;
	private transient Session session;

	public Device() {
		super();
	}

	public Device(Long id, String name, Session session) {
		super();
		this.id = id;
		this.name = name;
		this.session = session;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
