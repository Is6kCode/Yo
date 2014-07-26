package org.yo.rpc.registry;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.yo.api.UserService;
import org.yo.beans.User;
import org.yo.dao.UserDao;

import javax.annotation.Resource;
@Service
public class UserRegistry implements UserService {
	final Logger LOGGER = Logger.getLogger(UserRegistry.class);

	@Resource(name = "UserDao")
	UserDao userdao;
	public int Register(User user) {
		// TODO Auto-generated method stub
		try {
			return userdao.insert(user);
		} catch (DataAccessException e) {
			// TODO: handle exception
			LOGGER.error("注册用户数据库操作失败:"+e.getMessage());
			return 0;
		}
	}

}
