package net.kzm.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzm.shoppingbackend.dao.CategoryDAO;
import net.kzm.shoppingbackend.dto.Category;

public class CategoryTestCase {

	
	private static AnnotationConfigApplicationContext context;
	
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	
	@BeforeClass
	public static void init()
	{
		
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzm.shoppingbackend");
		context.refresh();
		//categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		
	}
	
	@Test
	public void testAddCategory()
	{
		
		category = new Category();
		
		category.setName("Television");
		category.setDescription("This is a television");
		category.setActive(true);
		category.setImageURL("Cat1_png");
		
		assertEquals("successfully added category inside the tabel",true,categoryDAO.add(category));
	}
}
