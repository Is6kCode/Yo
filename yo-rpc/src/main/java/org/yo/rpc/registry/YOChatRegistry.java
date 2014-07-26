package org.yo.rpc.registry;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.yo.api.YOChatService;
import org.yo.beans.Status;
import org.yo.beans.YOChat;
import org.yo.beans.YOChatType;
import org.yo.dao.YOChatDao;
@Repository("YOChatService")
@Service
public class YOChatRegistry implements YOChatService {
	final Logger LOGGER = Logger.getLogger(FriendshipRegistry.class);
	@Resource(name = "YOChatDao")
	YOChatDao yoChatDao;
	public int yoToFriend(Long sponsor, Long receiver) {
		YOChat chat = new YOChat();
		try {
			SimpleDateFormat df = new SimpleDateFormat("YYYYMMDDhhmmss");
			chat.setFromDate(df.format(new Date()));
			chat.setFromUser(sponsor);
			chat.setStatus(Status.GENERAL);
			chat.setToUser(receiver);
			chat.setType(YOChatType.UNACCEPT);
			yoChatDao.insertChat(chat);
			return 0;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return -1;
		}
	}

	public List<YOChat> getYoList(Long user) {
		// TODO Auto-generated method stub
		try {
			return yoChatDao.listChat(user);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return null;
		}
	}

	public List<YOChat> getUnacceptYoList(Long user) {
		// TODO Auto-generated method stub
		try {
			return yoChatDao.listChatByReceiver(user, YOChatType.UNACCEPT);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return null;
		}
	}

}
