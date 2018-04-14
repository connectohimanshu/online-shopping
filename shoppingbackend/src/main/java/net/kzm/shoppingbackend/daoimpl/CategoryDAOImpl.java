package net.kzm.shoppingbackend.daoimpl;


import java.util.List;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzm.shoppingbackend.dao.CategoryDAO;
import net.kzm.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		
		String selectActiveCategory = "FROM Category WHERE active = :active";
		return sessionFactory.getCurrentSession().createQuery(selectActiveCategory,Category.class).setParameter("active", true).getResultList();
	}

	//getting single category based on id
	
	@Override
	public Category get(int id) {
		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {
		// TODO Auto-generated method stub
		
		try {
			
			//add the category to database tabel
			sessionFactory.getCurrentSession().persist(category);
			
			return true;	
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public boolean update(Category category) {
		
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		
		category.setActive(false);
		
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
