package org.yo.rpc.registry;

import org.springframework.context.support.ClassPathXmlApplicationContext;
public class startBoot {

	    public static void main(String[] args) throws Exception {
	        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] 
	        		   {"classpath:applicationProvider.xml"});
	        
	        context.start();
	        System.out.println("输入任意字符终止程序");
	        System.in.read(); // 按任意键退出
	    }

}
