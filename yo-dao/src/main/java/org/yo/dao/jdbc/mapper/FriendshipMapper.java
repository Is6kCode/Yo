package org.yo.dao.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.yo.beans.FriendStatus;
import org.yo.beans.Friendship;

public class FriendshipMapper implements RowMapper<Friendship> {

	@Override
	public Friendship mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Friendship ship = new Friendship();
		ship.setID(rs.getLong("ID"));
		ship.setSponsor(rs.getLong("SPONSOR"));
		ship.setReceiver(rs.getLong("RECEIVER"));
		ship.setStatus(FriendStatus.valueOf(rs.getInt("STATUS")));
		return ship;
	}

}
