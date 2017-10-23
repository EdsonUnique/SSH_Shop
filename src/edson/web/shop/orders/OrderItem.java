package edson.web.shop.orders;

import edson.web.shop.product.Product;

/**
 * 订单项实体----对应购物项
 * @author Acer
 *
 */
public class OrderItem {

	private Integer id;
	private int count;//商品数量
	private double sum;//小计
	
	
	private Product product;
	private Order order;
	
	
	public final Integer getId() {
		return id;
	}
	public final void setId(Integer id) {
		this.id = id;
	}
	public final int getCount() {
		return count;
	}
	public final void setCount(int count) {
		this.count = count;
	}
	public final double getSum() {
		return sum;
	}
	public final void setSum(double sum) {
		this.sum = sum;
	}
	public final Product getProduct() {
		return product;
	}
	public final void setProduct(Product product) {
		this.product = product;
	}
	public final Order getOrder() {
		return order;
	}
	public final void setOrder(Order order) {
		this.order = order;
	}
	
	
	
	
}
