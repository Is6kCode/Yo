package org.yo.rpc;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-jdbc.xml" })
@TransactionConfiguration(defaultRollback = true)
public class TestBase extends AbstractJUnit4SpringContextTests {
	
	public String getJSON(Object obj){
		if(null == obj) return null;
		try {
			JSONObject js = new JSONObject();
			JSONArray jarry = JSONArray.fromObject(obj);
			js.put("list", jarry);
			return js.toString();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
}
