package org.yo.dao.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.yo.beans.Status;
import org.yo.beans.User;

public class UserMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		User user = new User();
		user.setID(rs.getLong("USER_ID"));
		user.setLastIp(rs.getString("LAST_IP"));
		user.setLastVisitTime(rs.getString("LAST_VISIT"));
		user.setName(rs.getString("USER_NAME"));
		user.setPassword(rs.getString("PASSWORD"));
		user.setStatus(Status.valueOf(rs.getInt("STATUS")));
		return user;
	}

}
