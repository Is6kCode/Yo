package org.yo.dao.jdbc.test;

import java.util.List;
import org.apache.log4j.Logger;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;
import org.yo.beans.User;
import org.yo.dao.UserDao;
import org.springframework.test.annotation.Rollback;
public class TestUserDao extends TestBase {
	final Logger LOGGER = Logger.getLogger(TestUserDao.class);
	@Resource(name = "userDao")
	UserDao userDao;
	@Test
	public void list(){
		try {
			  List<User> ls = userDao.list();
			  JSONObject js = new JSONObject();
			  JSONArray jss =  JSONArray.fromObject(ls);
			  js.put("users", jss);
			  System.out.println(js);
			  LOGGER.info(js);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
		}
	 
	}
	
	@Test
	@Rollback(true)
	public void add(){
	  User user = new User();
	  user.setName("abc");
	  try {
		  System.out.println("add :" + userDao.insert(user));
	} catch (Exception e) {
		// TODO: handle exception
		LOGGER.error(e.getMessage());
	}
	}


}
