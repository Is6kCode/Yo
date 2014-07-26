package org.yo.dao.jdbc.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.yo.beans.YOChat;
import org.yo.beans.YOChatType;
import org.yo.dao.YOChatDao;
import org.yo.dao.jdbc.mapper.YOChatMapper;

@Repository("YOChatDao")
public class YOChatDaoImpl extends JdbsSupport implements YOChatDao {
	final Logger LOGGER = Logger.getLogger(FriendshipDaoImpl.class);

	final String INSERT_CHAT = "INSERT INTO T_YO_CHAT(FROM_USER, TO_USER, FROM_DATE,TO_DATE, TYPE, STATUS)VALUES(" +
			" :fromUser, :toUser, :fromDate, :toDate, :type.value, :status.value)";
	final String QUERY_BASE_FIELD = "SELECT ID, FROM_USER,TO_USER, FROM_DATE,TO_DATE, TYPE, STATUS FROM T_YO_CHAT ";
	final String QUERY_BY_USER = QUERY_BASE_FIELD + " WHERE TO_USER = ? OR FROM_USER = ?";
	final String QUERY_BY_SENDER = QUERY_BASE_FIELD + " WHERE  OR FROM_USER = ? AND TYPE = ?";
	final String QUERY_BY_RECEIVER = QUERY_BASE_FIELD + " WHERE TO_USER = ? AND TYPE = ?";

	@Override
	public int insertChat(YOChat chat) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.updateForBean(INSERT_CHAT, chat);
	}

	@Override
	public List<YOChat> listChat(Long user) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getJdbcTemplate().query(QUERY_BY_USER, new Object[]{user,user}, new YOChatMapper());
	}

	@Override
	public List<YOChat> listChatBySender(Long user, YOChatType type)throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getJdbcTemplate().query(QUERY_BY_SENDER, new Object[]{user, type.value()}, new YOChatMapper());
	}

	@Override
	public List<YOChat> listChatByReceiver(Long user, YOChatType type)throws DataAccessException {
		// TODO Auto-generated method stub
		
		return this.getJdbcTemplate().query(QUERY_BY_RECEIVER, new Object[]{user, type.value()}, new YOChatMapper());
	}

}
