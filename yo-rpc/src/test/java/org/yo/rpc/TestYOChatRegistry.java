package org.yo.rpc;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.yo.api.YOChatService;
import org.yo.beans.YOChat;

public class TestYOChatRegistry extends TestBase {
	@Autowired
	YOChatService yoChatService;
	@Test
	public void TestSendYo(){
		yoChatService.yoToFriend(Long.valueOf(1), Long.valueOf(2));
	}
	@Test
	public void TestlistYo(){
		List<YOChat> ls = yoChatService.getYoList(Long.valueOf(1));
		System.out.println("TestlistYo："+ this.getJSON(ls));
	}
	@Test
	public void TestListUnaacept(){
		List<YOChat> ls = yoChatService.getUnacceptYoList(Long.valueOf(2));
		System.out.println("TestlistYo："+ this.getJSON(ls));
	}
}
