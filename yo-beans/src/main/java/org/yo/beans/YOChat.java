package org.yo.beans;

public class YOChat implements ID {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3103752398732910383L;

	private Long ID;
	private Long fromUser;
	private Long toUser;
	private String fromDate;
	private String toDate;
	private Status status;
	private YOChatType type;
	
	public YOChatType getType() {
		return type;
	}
	public void setType(YOChatType type) {
		this.type = type;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public Long getFromUser() {
		return fromUser;
	}
	public void setFromUser(Long fromUser) {
		this.fromUser = fromUser;
	}
	public Long getToUser() {
		return toUser;
	}
	public void setToUser(Long toUser) {
		this.toUser = toUser;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}


	

}
