package org.yo.beans;
/**
 * 好友关系
 * @author liukai
 * @version 创建时间：2014-6-28  下午5:38:35
 *
 */
public class Friendship implements ID {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6774079212025664898L;
	private Long ID;
	private Long sponsor;
	private Long receiver;
	private FriendStatus status;
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public Long getSponsor() {
		return sponsor;
	}
	public void setSponsor(Long sponsor) {
		this.sponsor = sponsor;
	}
	public Long getReceiver() {
		return receiver;
	}
	public void setReceiver(Long receiver) {
		this.receiver = receiver;
	}
	public FriendStatus getStatus() {
		return status;
	}
	public void setStatus(FriendStatus status) {
		this.status = status;
	}

}
