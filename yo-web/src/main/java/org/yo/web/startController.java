package org.yo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller  
public class startController {
	  
		@ModelAttribute("json")
		public ServerResponse getJson(){
			ServerResponse response = new ServerResponse();
			response.setMessage("ok");
			response.setRetCode(Long.valueOf(200));
			return response;
		}
	    @RequestMapping(value="/login", method = RequestMethod.GET)  
	    public String index_jsp(Model model, @ModelAttribute("json")ServerResponse response ){  
	        //model.addAttribute("liming", "黎明你好");
	    	response.setData("测试数据哦");
	    	//ModelAndView
	        //System.out.println("index.jsp");
	    	return "listJson";
	    }  
}
