package org.yo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

//    @Autowired
//	UserService userService;
	/**
	 * 用户注册接口
	 */
	 @RequestMapping(value="/user/reg", method = RequestMethod.GET)  
	    public ModelAndView usrReg(@RequestParam(value="username")String userName){  
	        //model.addAttribute("liming", "黎明你好");
		    ModelAndView mva = new ModelAndView("listJson");
//		    User user = new User();
//		    userService.Register(user);
//	        //System.out.println("index.jsp");
	    	return mva;
	    }  
}
