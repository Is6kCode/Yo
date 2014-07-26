package org.yo.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.yo.beans.User;

/**
 * 
 */
public interface UserDao {

	/**
	 * 
	 * @param Name
	 * @return
	 * @throws DataAccessException
	 */
	User findUserByName(String Name) throws DataAccessException;
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws DataAccessException
	 */
	int  insert(User user) throws DataAccessException;
	/**
	 * 
	 * @return
	 * @throws DataAccessException
	 */
	List<User> list()throws DataAccessException;
}
