package edson.web.shop.orders;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edson.web.shop.exception.DaoException;
import edson.web.shop.product.Product;
import edson.web.shop.utils.PageBean;
@SuppressWarnings("all")
public class OrderDao extends HibernateDaoSupport{

	public void saveOrder(Order order) throws DaoException {
		try{
			this.getHibernateTemplate().save(order);
			
		}catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public List<Order> findByUserId(Integer id) throws DaoException {
		try{
			return this.getHibernateTemplate().find("from Order o where o.user.id=?",id);
			
		}catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public Order findByOrderId(Integer id) throws DaoException {
		try{
			List<Order> orders=this.getHibernateTemplate().find("from Order o where o.id=?",id);
			if(orders==null || orders.size()<=0){
				return null;
			}
			
			return orders.get(0);
			
		}catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public void updateOrder(Order order) {
		Order a_order=(Order) this.getHibernateTemplate().find("from Order o where o.id=?",order.getId()).get(0);
		a_order.setState(order.getState());
		this.getHibernateTemplate().update(a_order);
	}

	public PageBean<Order> viewAllOrders(final Integer pagenum) throws DaoException {
		try{
			Integer totalRecord;
			String hql="select count(*) from Order";//查询总共记录数
			totalRecord=findTotalRecord(hql,null);
			
			List<Order> cs=this.getHibernateTemplate().executeFind(new HibernateCallback<List<Order>>() {

				@Override
				public List<Order> doInHibernate(Session session)
						throws HibernateException, SQLException {
					String hql="from Order";
					return  session.createQuery(hql)
											.setFirstResult((pagenum-1)*12)
											.setMaxResults(12)
											.list();
					
				}
			});
			
			PageBean pb=new PageBean(pagenum,totalRecord,cs);
			pb.setPath("/order/order_viewAllOrders");
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

	public Order findOrder(Integer id) {
		List<Order> orders=this.getHibernateTemplate().find("from Order o where o.id=?",id);
		if(orders==null|| orders.size()<=0){
			return null;
		}
		return orders.get(0);
	}

	public void deleteOrder(Order order) {
		this.getHibernateTemplate().delete(order);
	}

	
	

}
