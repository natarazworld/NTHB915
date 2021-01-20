package com.nt.entity;

public interface IActor {
	public Integer getActorId(); 
	public void setActorId(Integer actorId) ;
	public String getActorName() ;
	public void setActorName(String actorName);
	public String getActorAddrs();
	public void setActorAddrs(String actorAddrs);
	public Long getPhone();
	public void setPhone(Long phone);
	public Float getRemuneration();
	public void setRemuneration(Float remuneration); 
}
