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
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		
	}
	
//	@Test
//	public void testAddCategory()
//	{
//		
//		category = new Category();
//		
//		category.setName("Mobile");
//		category.setDescription("This is a mobile");
//		category.setActive(true);
//		category.setImageURL("mobile_png");
//		
//		assertEquals("successfully added category inside the tabel",true,categoryDAO.add(category));
//	}
//	
	
//	@Test
//	public void testGetCategory() {
//		
//		category = categoryDAO.get(1);
//		assertEquals("successfully fetched a single category from the table","Television",categoryDAO.add(category));
//	}
	
	
	
//	@Test
//	public void testUpadateCategory() {
//		
//		category = categoryDAO.get(1);
//		category.setName("Laptop");
//		assertEquals("successfully updated a single category from the table",true,categoryDAO.update(category));
//	}
	
	
//	@Test
//	public void testDeleteCategory() {
//		
//		category = categoryDAO.get(1);
//		assertEquals("successfully updated a single category from the table",true,categoryDAO.delete(category));
//	}
	
	
	
//	@Test
//	public void testListCategory() {
//		
//		assertEquals("successfully updated a single category from the table",3,categoryDAO.list().size());
//	}
	
	
	@Test
	public void testCRUDCategory()
	{
		
		//addding the category
		category = new Category();	
		category.setName("Mobile");
		category.setDescription("This is a mobile");
		category.setActive(true);
		category.setImageURL("mobile_png");
		
		assertEquals("successfully added category inside the tabel",true,categoryDAO.add(category));
		
		//fetching and updating category
		category = categoryDAO.get(1);
		category.setName("Laptop");
		assertEquals("successfully updated a single category from the table",true,categoryDAO.update(category));
		
		//deleting the category
		category = categoryDAO.get(1);
		assertEquals("successfully updated a single category from the table",true,categoryDAO.delete(category));
		
//		fetching the list
		assertEquals("successfully updated a single category from the table",3,categoryDAO.list().size());
	}
	
	
	
	
	
}
