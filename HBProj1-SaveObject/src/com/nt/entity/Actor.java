//Actor.java (Entity class)
package com.nt.entity;

public class Actor {
	private int actorId;
	private String actorName;
	private String actorAddrs;
	private long phone;
	private float remuneration;

	// getters & setters (alt+shift+s, r)
	//To format the code  ctrl+shift+F
	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getActorAddrs() {
		return actorAddrs;
	}

	public void setActorAddrs(String actorAddrs) {
		this.actorAddrs = actorAddrs;
	}

	public long getPhone() {
		System.out.println("Actor.getPhone()");
		return phone;
	}

	public void setPhone(long phone) {
		System.out.println("Actor.setPhone()");
		this.phone = phone;
	}

	public float getRemuneration() {
		return remuneration;
	}

	public void setRemuneration(float remuneration) {
		this.remuneration = remuneration;
	}
	
	//toString()  method  (alt+shift+s,s)
	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", actorName=" + actorName + ", actorAddrs=" + actorAddrs + ", phone="
				+ phone + ", remuneration=" + remuneration + "]";
	}
	
	
	

}
