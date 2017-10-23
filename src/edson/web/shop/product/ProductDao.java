package edson.web.shop.product;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edson.web.shop.category.Category;
import edson.web.shop.categorysecond.CategorySecond;
import edson.web.shop.exception.DaoException;
import edson.web.shop.orders.Order;
import edson.web.shop.utils.PageBean;

public class ProductDao extends HibernateDaoSupport{

	//查询10条记录
	public List<Product> findByHot() throws DaoException {
		try{
			//离线查询
			DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
			criteria.add(Restrictions.eq("is_hot", "1"));
			List<Product> products=this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
			return products;
		}catch (Exception e) {
			throw new DaoException(e);
		}
		
	}

	public List<Product> findByNew() throws DaoException {
		try{
			//离线查询
			DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
			criteria.add(Restrictions.sqlRestriction("1=1 order by pdate"));
			List<Product> products=this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
			return products;
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

	public Product findById(Integer id) throws DaoException {
		try{
			List<Product> ps=this.getHibernateTemplate().find("from Product where pid=?",id);
			if(ps.size()>0){
				return ps.get(0);
			}
			return null;
		}catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public PageBean<Product> viewAllProduct(final Integer pagenum) throws DaoException {
		try{
			Integer totalRecord;
			String hql="select count(*) from Product";//查询总共记录数
			totalRecord=findTotalRecord(hql,null);
			
			List<Product> cs=this.getHibernateTemplate().executeFind(new HibernateCallback<List<Product>>() {

				@Override
				public List<Product> doInHibernate(Session session)
						throws HibernateException, SQLException {
					String hql="from Product";
					return  session.createQuery(hql)
											.setFirstResult((pagenum-1)*12)
											.setMaxResults(12)
											.list();
					
				}
			});
			
			PageBean pb=new PageBean(pagenum,totalRecord,cs);
			pb.setPath("/product/product_viewAllProduct");
			return pb;
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

		public List<CategorySecond> findAllCategorySecond() {
			return this.getHibernateTemplate().find("from CategorySecond");
		}

		public void saveProduct(Product product) {
			this.getHibernateTemplate().save(product);
		}

		public CategorySecond findCategorySecondById(Integer id) {
			List<CategorySecond> list=this.getHibernateTemplate().find("from CategorySecond cs where cs.id=?",id);
			if(list==null || list.size()<=0){
				return null;
			}
			return list.get(0);
		}

		public void updateProduct(Product product) {
			this.getHibernateTemplate().update(product);
		}

		public void deleteProduct(Product product) {
			this.getHibernateTemplate().delete(product);
		}

}
