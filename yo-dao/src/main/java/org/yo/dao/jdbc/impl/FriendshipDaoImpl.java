package org.yo.dao.jdbc.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.yo.beans.Friendship;
import org.yo.dao.FriendshipDao;
import org.yo.dao.jdbc.mapper.FriendshipMapper;
@Repository("FriendshipDao")
public class FriendshipDaoImpl  extends JdbsSupport implements FriendshipDao {

	final Logger LOGGER = Logger.getLogger(FriendshipDaoImpl.class);
	final String INSERT_SHIP = "INSERT INTO T_FRIENDS(SPONSOR, RECEIVER, STATUS) VALUES(" +
			" :sponsor, :receiver, :status.value)";
	final String QUERY_BASE_FIELD  = "SELECT T.ID, T.SPONSOR, T.RECEIVER, T.`STATUS` FROM T_FRIENDS T";
	final String QUERY_SHIP_BY_USER = QUERY_BASE_FIELD + " WHERE T.SPONSOR = ? OR T.RECEIVER = ?";
	final String QUERY_SHIP_BY_A_B = QUERY_BASE_FIELD + " WHERE (T.SPONSOR = ? AND T.RECEIVER = ?) OR (T.RECEIVER = ? AND T.SPONSOR = ?)";
	final String QUERY_SHIP_BY_ID = QUERY_BASE_FIELD + " WHERE ID = ?";

	final String UPDATE_SHIP = "UPDATE T_FRIENDS SET SPONSOR = :sponsor, RECEIVER = :receiver , `STATUS` = :status.value";
	@Override
	public int insert(Friendship ship) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.updateForBean(INSERT_SHIP, ship);
	}

	@Override
	public List<Friendship> listbyUser(Long user) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			return this.getJdbcTemplate().query(QUERY_SHIP_BY_USER, new Object[]{user,user}, new FriendshipMapper());
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public Friendship find(Long userA, Long userB) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			return this.getJdbcTemplate().queryForObject(QUERY_SHIP_BY_A_B, new Object[]{userA, userB, userA, userB}, new FriendshipMapper());
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public void update(Friendship ship) throws DataAccessException {
		this.updateForBean(UPDATE_SHIP, ship);
	}

	@Override
	public Friendship find(Long shipId) throws DataAccessException {
		
		try {
			return this.getJdbcTemplate().queryForObject(QUERY_SHIP_BY_ID, new Object[]{shipId}, new FriendshipMapper());
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			return null;
		}
	}

}
