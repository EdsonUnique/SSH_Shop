package edson.web.shop.categorysecond;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edson.web.shop.category.Category;
import edson.web.shop.exception.DaoException;
import edson.web.shop.product.Product;
import edson.web.shop.utils.PageBean;

/**
 * 二级分类
 * @author Acer
 *
 */
@SuppressWarnings("all")
public class CategorySecondDao extends HibernateDaoSupport{

	
	public PageBean<Product> findByFirstId(final String fid, final Integer pagenum) throws DaoException {
		try{
			Integer totalRecord;
			String hql="select count(*) from Product p inner join p.csecond as cs  where cs.cfirst.id=?";//查询总共记录数
			totalRecord=findTotalRecord(hql,new Object[]{fid});
			
			List<Product> cs=this.getHibernateTemplate().executeFind(new HibernateCallback<List<Product>>() {

				@Override
				public List<Product> doInHibernate(Session session)
						throws HibernateException, SQLException {
					String hql="from Product p inner join fetch p.csecond as cs  where cs.cfirst.id=?";
					return  session.createQuery(hql).setParameter(0, Integer.valueOf(fid))
											.setFirstResult((pagenum-1)*12)
											.setMaxResults(12)
											.list();
					
				}
			});
			
			PageBean pb=new PageBean(pagenum,totalRecord,cs);
			pb.setPath("/category/categorysecond_searchSecondCategory");
			return pb;
		}catch (Exception e) {
			throw new DaoException(e);
		}
		
	}

	public List<Category> findAllFirstCateory() throws DaoException {
		try{
			
			List<Category> fs=this.getHibernateTemplate().find("from Category");
			
			return fs;
		}catch (Exception e) {
			throw new DaoException(e);
		}
	}

	//根据hql查询所有记录
	public Integer findTotalRecord(String hql,Object[] params) {
		List<Long> pageRecord;
		if(params==null || params.length<=0){
			pageRecord=this.getHibernateTemplate().find(hql);
		}else{
			pageRecord=this.getHibernateTemplate().find(hql,Integer.valueOf(params[0].toString()));
		}
		if(pageRecord.size()<=0)return null;
		return pageRecord.get(0).intValue();
	}

	public PageBean<Product> findBySecondId(final String sid, final Integer pagenum) throws DaoException {
		
		try{
			Integer totalRecord;
			String hql="select count(*) from Product p where p.csecond.id=?";//查询总共记录数
			totalRecord=findTotalRecord(hql,new Object[]{sid});
			
			List<Product> cs=this.getHibernateTemplate().executeFind(new HibernateCallback<List<Product>>() {

				@Override
				public List<Product> doInHibernate(Session session)
						throws HibernateException, SQLException {
					String hql="from Product p where p.csecond.id=?";
					return  session.createQuery(hql).setParameter(0, Integer.valueOf(sid))
											.setFirstResult((pagenum-1)*12)
											.setMaxResults(12)
											.list();
					
				}
			});
			
			PageBean pb=new PageBean(pagenum,totalRecord,cs);
			pb.setPath("/category/categorysecond_searchDetailSecondCategory");
			return pb;
		}catch (Exception e) {
			throw new DaoException(e);
		}
		
	}

	public PageBean<CategorySecond> findAllCategorySecond(final Integer pagenum) throws DaoException {
		
		try{
			Integer totalRecord;
			String hql="select count(*) from CategorySecond";//查询总共记录数
			totalRecord=findTotalRecord(hql,null);
			
			List<CategorySecond> cs=this.getHibernateTemplate().executeFind(new HibernateCallback<List<CategorySecond>>() {

				@Override
				public List<CategorySecond> doInHibernate(Session session)
						throws HibernateException, SQLException {
					String hql="from CategorySecond";
					return  session.createQuery(hql)
											.setFirstResult((pagenum-1)*12)
											.setMaxResults(12)
											.list();
					
				}
			});
			
			PageBean pb=new PageBean(pagenum,totalRecord,cs);
			pb.setPath("/category/categorysecond_viewAllCategorySecond");
			return pb;
		}catch (Exception e) {
			throw new DaoException(e);
		}
		
	}

	public Category findFirstCategory(String fid) {
		Integer id=Integer.valueOf(fid);
		List<Category> c=this.getHibernateTemplate().find("from Category c where c.id=?",id);
		if(c==null){
			return null;
		}
		
		return c.get(0);
	}

	public void addCategorySecond(CategorySecond cs) {
		this.getHibernateTemplate().save(cs);
	}

	public void updateCategorySecond(CategorySecond cs) {
		CategorySecond a_cs=(CategorySecond)( this.getHibernateTemplate().find("from CategorySecond cs where cs.id=?",cs.getId()).get(0));
		a_cs.setCfirst(cs.getCfirst());
		a_cs.setName(cs.getName());
		this.getHibernateTemplate().update(a_cs);
	
	}

	public CategorySecond findCategorySecond(String sid) {
		Integer id=Integer.valueOf(sid);
		List<CategorySecond> c=this.getHibernateTemplate().find("from CategorySecond c where c.id=?",id);
		if(c==null){
			return null;
		}
		
		return c.get(0);
	}

	public void deleteCategorySecond(CategorySecond cs) {
		this.getHibernateTemplate().delete(cs);
	}
	
	
	
	
}
