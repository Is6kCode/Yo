package org.yo.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.yo.beans.Friendship;

public interface FriendshipDao {

	/**
	 * 插入一套记录
	 * @param ship
	 * @return
	 * @throws DataAccessException
	 */
	int insert(Friendship ship) throws DataAccessException;
	
	/**
	 * 查询和USER相关的好友信息
	 * @param user
	 * @return  
	 * @throws DataAccessException
	 */
	List<Friendship> listbyUser(Long user)  throws DataAccessException;
	/**
	 * 
	 * @param userA
	 * @param userB
	 * @return
	 * @throws DataAccessException
	 */
	Friendship find(Long userA, Long userB) throws DataAccessException;
	
	/**
	 * 
	 * @param shipId
	 * @return
	 * @throws DataAccessException
	 */
	Friendship find(Long shipId) throws DataAccessException;
	/**
	 * 
	 * @param ship
	 * @return
	 * @throws DataAccessException
	 */
	void update(Friendship ship) throws DataAccessException;
	
}
