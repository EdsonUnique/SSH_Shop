package edson.web.shop.orders;

import java.util.List;

import edson.web.shop.exception.DaoException;
import edson.web.shop.utils.PageBean;

public class OrderService {
	
	private OrderDao odao;

	public final void setOdao(OrderDao odao) {
		this.odao = odao;
	}

	public void saveOrder(Order order) throws DaoException {
		odao.saveOrder(order);
		
	}

	public List<Order> findByUserId(Integer id) throws DaoException {
		
		return odao.findByUserId(id);
	}

	public Order findByOrderId(Integer id) throws DaoException {
		return odao.findByOrderId(id);
	}

	public void updateOrder(Order order) {
		odao.updateOrder(order);
		
	}

	public PageBean<Order> viewAllOrders(Integer pagenum) throws DaoException {
		return odao.viewAllOrders(pagenum);
	}

	public Order findOrder(Integer id) {
		return odao.findOrder(id);
	}

	public void deleteOrder(Order order) {
		odao.deleteOrder(order);
		
	}
	
	
	
	
}
