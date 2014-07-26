package org.yo.beans;

public enum Status {

	// 正常
	GENERAL(0),
	// 删除
	DELETED(1),
	// 过期无效
	INVALID(2);

	private int value;

	private Status(int value) {
		this.value = value;
	}
    public int getValue(){
    	return this.value;
    }
	public int value() {
		return this.value;
	}

	public static Status valueOf(int value) {
		for (Status s : Status.values()) {
			if (s.value == value) {
				return s;
			}
		}
		return INVALID;
	}

}
