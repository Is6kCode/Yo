package org.yo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	    public String log(Model model, @ModelAttribute("json")ServerResponse response ){  
	        //model.addAttribute("liming", "黎明你好");
	    	response.setData("测试数据哦");
	    	//ModelAndView
	        //System.out.println("index.jsp");
	    	return "listJson";
	    }  
	    @RequestMapping(value="/reg", method = RequestMethod.GET)  
	    public ModelAndView reg(@RequestParam(value="username")String userName ){  
	        //model.addAttribute("liming", "黎明你好");
		    ModelAndView mva = new ModelAndView("listJson");
		    ServerResponse responder = this.getJson();
		    responder.setData(userName);
		    mva.addObject(responder);
	    	//ModelAndView
	        //System.out.println("index.jsp");
	    	return mva;
	    }  
	    
}
