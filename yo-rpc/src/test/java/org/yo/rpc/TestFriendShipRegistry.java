package org.yo.rpc;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.yo.api.FriendshipService;
import org.yo.beans.Friendship;

public class TestFriendShipRegistry extends TestBase {

	@Autowired
	FriendshipService friendshipService;
	@Test
	public  void TestBuildShip(){
		friendshipService.buildShip(Long.valueOf(1), Long.valueOf(2));
	}
	@Test
	public  void TestCancelShip(){
		friendshipService.cancelShip(Long.valueOf(1));
	}
	@Test
	public  void TestListShip(){
	   List<Friendship> ls=	friendshipService.listByUser(Long.valueOf(1));
	   System.out.println(this.getJSON(ls));
	}
	
}
