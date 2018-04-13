package net.kzm.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.kzm.shoppingbackend.dao.CategoryDAO;
import net.kzm.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();
	
	static {
		
		Category category1 = new Category();
		category1.setId(1);
		category1.setName("Television");
		category1.setDescription("This is a television");
		category1.setActive(true);
		category1.setImageURL("Cat1_png");
		
		categories.add(category1);
		
		Category category2 = new Category();
		category2.setId(2);
		category2.setName("Mobile");
		category2.setDescription("This is a Mobile");
		category2.setActive(true);
		category2.setImageURL("Cat2_png");
		
		categories.add(category2);
		
		Category category3 = new Category();
		category3.setId(3);
		category3.setName("Laptops");
		category3.setDescription("This is a laptops");
		category3.setActive(true);
		category3.setImageURL("Cat3_png");
		
		categories.add(category3);
	}
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		//enhance forloop
		for(Category category : categories)
		{
			if(category.getId()==id)
			return category;
		}
		return null;
	}

}
