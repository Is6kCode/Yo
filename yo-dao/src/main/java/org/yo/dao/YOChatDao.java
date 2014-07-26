package org.yo.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.yo.beans.YOChat;
import org.yo.beans.YOChatType;

public interface YOChatDao {

	/**
	 * 
	 * @param chat
	 * @return
	 * @throws DataAccessException
	 */
	int insertChat(YOChat chat) throws DataAccessException;
	/**
	 * 查询user相关的聊天记录
	 * @param user
	 * @return
	 */
	List<YOChat> listChat(Long user) throws DataAccessException;
	/**
	 * 查询发送者的聊天
	 * @param user
	 * @param type
	 * @return
	 */
	List<YOChat> listChatBySender(Long user, YOChatType type) throws DataAccessException;
	/**
	 * 查询接受者的聊天
	 * @param user
	 * @param type
	 * @return
	 */
	List<YOChat> listChatByReceiver(Long user, YOChatType type)throws DataAccessException;
	
}
