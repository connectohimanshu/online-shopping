 package net.kzm.shoppingbackend.dao;

import java.util.List;

import net.kzm.shoppingbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	Category get(int id);
	
}
