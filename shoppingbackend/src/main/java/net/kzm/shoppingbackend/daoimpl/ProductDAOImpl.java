package net.kzm.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzm.shoppingbackend.dao.ProductDAO;
import net.kzm.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Product get(int productId) {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
 
	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("FROM Product",Product.class).getResultList();
	}

	@Override
	public boolean add(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean delete(Product product) {
		// TODO Auto-generated method stub`
		try {
			product.setActive(false);
			return this.update(product);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<Product> listActiveProducts() {
		// TODO Auto-generated method stub
		String selectActiveProducts="FROM Product WHERE active = :active";
		return sessionFactory.getCurrentSession().createQuery(selectActiveProducts,Product.class).setParameter("active", true).getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategoryId="FROM Product WHERE active = :active AND categoryId = :categoryId";
		return sessionFactory.getCurrentSession().createQuery(selectActiveProductsByCategoryId,Product.class)
				.setParameter("active", true)
				.setParameter("categoryId", categoryId)
				.getResultList();
		
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		String selectLatestActiveProducts="FROM Product WHERE active = :active ORDER BY id";
		return sessionFactory.getCurrentSession().createQuery(selectLatestActiveProducts,Product.class)
				.setParameter("active", true)
					.setFirstResult(0)
					.setMaxResults(count)
					.getResultList();
	}

}
