package org.yo.rpc.registry;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.yo.api.FriendshipService;
import org.yo.beans.FriendStatus;
import org.yo.beans.Friendship;
import org.yo.dao.FriendshipDao;

@Repository("FriendshipRegistry")
@Service
public class FriendshipRegistry implements FriendshipService {
	final Logger LOGGER = Logger.getLogger(FriendshipRegistry.class);
	@Resource(name = "FriendshipDao")
	FriendshipDao friendshipDao;

	public List<Friendship> listByUser(Long userID) {
		// TODO Auto-generated method stub
		try {
			return friendshipDao.listbyUser(userID);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return null;
		}
	}

	@Transactional(readOnly = false, rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public boolean buildShip(Long sponsor, Long reveiver) {
		// TODO Auto-generated method stub
		try {
			Friendship ship = friendshipDao.find(sponsor, reveiver);
			if (null != ship) {
				// 存在关系，跟新一下状态
				if (FriendStatus.GENERAL != ship.getStatus()) {
					ship.setStatus(FriendStatus.GENERAL);
					friendshipDao.update(ship);
				}
				return true;
			}
			ship = new Friendship();
			ship.setSponsor(sponsor);
			ship.setReceiver(reveiver);
			ship.setStatus(FriendStatus.GENERAL);
			friendshipDao.insert(ship);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return false;
		}
	}

	@Transactional(readOnly = false, rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public boolean cancelShip(Long shipId) {
		// TODO Auto-generated method stub
		try {
			Friendship ship = friendshipDao.find(shipId);
			if (null != ship) {
				ship.setStatus(FriendStatus.DELETED);
				friendshipDao.update(ship);
			}
			return true;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return false;
		}
	}

}
