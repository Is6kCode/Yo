package org.yo.beans;

public class User implements ID {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4505902553748817479L;
    private  Long ID;
    private  String name;
    private  String password;
	private  String lastVisitTime;
    private  String lastIp;
    private Status status;
    
    
    
    public User(){
    	super();
    	this.status = Status.GENERAL;
    }
    public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLastVisitTime() {
		return lastVisitTime;
	}
	public void setLastVisitTime(String lastVisitTime) {
		this.lastVisitTime = lastVisitTime;
	}
	public String getLastIp() {
		return lastIp;
	}
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

}
