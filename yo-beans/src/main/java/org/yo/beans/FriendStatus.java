package org.yo.beans;

public enum FriendStatus {

	// 正常
	GENERAL(0),
	//未接受
	UNACCEPT(1),
	// 删除
	DELETED(2);

	private int value;

	private FriendStatus(int value) {
		this.value = value;
	}
    public int getValue(){
    	return this.value;
    }
	public int value() {
		return this.value;
	}

	public static FriendStatus valueOf(int value) {
		for (FriendStatus s : FriendStatus.values()) {
			if (s.value == value) {
				return s;
			}
		}
		return GENERAL;
	}

}
