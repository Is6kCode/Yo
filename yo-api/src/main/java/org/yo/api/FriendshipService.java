package org.yo.api;

import java.util.List;

import org.yo.beans.Friendship;

/**
 * 
 * @author liukai
 * @version 创建时间：2014-6-30  下午2:39:16
 *
 */
public interface FriendshipService {
    
	/**
	 * 查询用户的朋友列表
	 * @param userID
	 * @return
	 */
	List<Friendship> listByUser(Long userID);
	/**
      * 建立关系 
      * @param sponsor
      * @param reveiver
      * @return 关系ID， 失败返回-1
      */
	boolean buildShip(Long sponsor, Long reveiver);
	/**
	 * 取消关系
	 * @param shipId
	 * @return
	 */
	boolean cancelShip(Long shipId);
	
}
