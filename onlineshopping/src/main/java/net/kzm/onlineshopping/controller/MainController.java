package net.kzm.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping(value = {"/","/index","/home"})
	public ModelAndView maincontroller()
	{
			ModelAndView mv = new ModelAndView("page");
			mv.addObject("title","Home");
			mv.addObject("userClickHome",true);
			return mv;
	}
	
	
	@RequestMapping("/contact")
	public ModelAndView contact()
	{
			ModelAndView mv = new ModelAndView("page");
			mv.addObject("title","Contact");
			mv.addObject("userClickContact",true);
			return mv;
	}
	

	@RequestMapping("/about")
	public ModelAndView about()
	{
			ModelAndView mv = new ModelAndView("page");
			mv.addObject("title","About");
			mv.addObject("userClickAbout",true);
			return mv;
	}
}
