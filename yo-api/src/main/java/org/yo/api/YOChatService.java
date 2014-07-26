package org.yo.api;
import java.util.List;

import org.yo.beans.YOChat;
/**
 * 
 * @author liukai
 * @version 创建时间：2014-7-2  下午2:26:09
 *
 */
public interface YOChatService {

	/**
	 * 给好友发送yo请求
	 * @param sponsor
	 * @param receiver
	 * @return 0 成功
	 */
	int yoToFriend(Long sponsor, Long receiver);
	/**
	 * 获取所有聊天记录
	 * @param user
	 * @return
	 */
	List<YOChat>getYoList(Long user);
	
	/**
	 * 获取未接受的yo
	 * @param user
	 * @return
	 */
	List<YOChat>getUnacceptYoList(Long user);
}
