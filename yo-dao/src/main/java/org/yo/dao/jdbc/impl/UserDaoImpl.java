package org.yo.dao.jdbc.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.yo.beans.User;
import org.yo.dao.UserDao;
import org.yo.dao.jdbc.mapper.UserMapper;

@Repository("UserDao")
public class UserDaoImpl extends JdbsSupport  implements UserDao {

	final String QUERY_BASE_FIELD = " SELECT USER_ID, USER_NAME, PASSWORD, LAST_VISIT, LAST_IP, STATUS FROM T_USER ";
	final String QUERY_ALL = QUERY_BASE_FIELD;
	final String INSERT_USER = "INSERT INTO T_USER(USER_NAME, PASSWORD, LAST_VISIT, LAST_IP, STATUS) VALUES(:name, :password, :lastVisitTime," +
			" :lastIp, :status.value)";
	
	
	public User findUserByName(String Name) throws DataAccessException{
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> list() throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getJdbcTemplate().query(QUERY_ALL, new Object[]{}, new UserMapper());
	}

	@Override
	public int insert(User user) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.updateForBean(INSERT_USER, user);
	}

}
