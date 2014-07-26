package org.yo.dao.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.yo.beans.Status;
import org.yo.beans.YOChat;
import org.yo.beans.YOChatType;

public class YOChatMapper implements RowMapper<YOChat> {

	@Override
	public YOChat mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		YOChat log = new YOChat();
		log.setFromDate(rs.getString("FROM_DATE"));
		log.setFromUser(rs.getLong("FROM_USER"));
		log.setToDate(rs.getString("TO_DATE"));
		log.setToUser(rs.getLong("TO_USER"));
		log.setID(rs.getLong("ID"));
		log.setStatus(Status.valueOf(rs.getInt("STATUS")));
		log.setType(YOChatType.valueOf(rs.getInt("TYPE")));
		return log;
	}

}
