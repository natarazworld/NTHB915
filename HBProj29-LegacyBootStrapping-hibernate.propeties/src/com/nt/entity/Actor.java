//Actor.java (Entity class)
package com.nt.entity;

public final class Actor {
	private Integer actorId;
	private String actorName;
	private String actorAddrs;
	private Long phone;
	private Float remuneration;
	
	public Actor() {
		System.out.println("Actor: 0-param construcotr"+this.getClass()+" ---->"+this.getClass().getSuperclass());
	}

	// getters & setters (alt+shift+s, r)
	//To format the code  ctrl+shift+F
	public Integer getActorId() {
		return actorId;
	}

	public void setActorId(Integer actorId) {
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

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Float getRemuneration() {
		return remuneration;
	}

	public void setRemuneration(Float remuneration) {
		this.remuneration = remuneration;
	}
	
	//toString()  method  (alt+shift+s,s)
	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", actorName=" + actorName + ", actorAddrs=" + actorAddrs + ", phone="
				+ phone + ", remuneration=" + remuneration + "]";
	}
	
	
	

}
