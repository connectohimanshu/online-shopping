package net.kzm.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.kzm.shoppingbackend.dao.CategoryDAO;
import net.kzm.shoppingbackend.dto.Category;

@Controller
public class MainController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	

	@RequestMapping(value = {"/","/index","/home"})
	public ModelAndView maincontroller()
	{
			ModelAndView mv = new ModelAndView("page");
			mv.addObject("title","Home");
			
			//passing list of categories
			mv.addObject("categories",categoryDAO.list()); 
			
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
	
	/*method to show all products based on category*/
	
	@RequestMapping(value= {"/show/all/products"} ,method=RequestMethod.GET)
	public ModelAndView showAllProducts()
	{
			ModelAndView mv = new ModelAndView("page");
			mv.addObject("title","All Products");
			
			//passing list of categories
			mv.addObject("categories",categoryDAO.list()); 
			
			mv.addObject("userClickAllProducts",true);
			return mv;
	
	}
	
	

	@RequestMapping("/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id")int id)
	{
			ModelAndView mv = new ModelAndView("page");
			
			/*category dao to fetch single category*/

			Category category = null;
			category = categoryDAO.get(id); 
			mv.addObject("title",category.getName());
			
			//passing list of categories
			mv.addObject("categories",categoryDAO.list()); 
			
			//passing single category
			mv.addObject("category",category);
			mv.addObject("userClickCategoryProducts",true);
			return mv;
	}
	
	
}
