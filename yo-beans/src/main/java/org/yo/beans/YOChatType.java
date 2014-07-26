package org.yo.beans;

public enum YOChatType {
	// 正常
		UNACCEPT(0, "未接受"),
		// 删除
		ACCEPT(1, "已经接受");

		private int value;
		private String description;
		
		private YOChatType(int value, String description) {
			this.value = value;
			this.description = description;
		}
	    public int getValue(){
	    	return this.value;
	    }
	    public String getDescription(){
	    	return this.description;
	    }
		public int value() {
			return this.value;
		}

		public static YOChatType valueOf(int value) {
			for (YOChatType s : YOChatType.values()) {
				if (s.value == value) {
					return s;
				}
			}
			return UNACCEPT;
		}
}
