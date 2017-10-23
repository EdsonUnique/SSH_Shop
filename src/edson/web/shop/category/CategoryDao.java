package edson.web.shop.category;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edson.web.shop.exception.DaoException;

public class CategoryDao extends HibernateDaoSupport{

	public List<Category> findAllCategory() throws DaoException {
		try{
			List<Category> categories=this.getHibernateTemplate().find("from Category");
			return categories;
		}catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public void addCategory(Category category) {
		this.getHibernateTemplate().save(category);
		
	}

	public void updateCategory(Category category) {
		//先查再修改（对于一对多关系）
		Category o_category=(Category) this.getHibernateTemplate().find("from Category c where c.id=? ",category.getId()).get(0);
		o_category.setName(category.getName());
		this.getHibernateTemplate().update(o_category);
	}

	public void deleteCategory(Category category) {
		this.getHibernateTemplate().delete(category);
	}

}
