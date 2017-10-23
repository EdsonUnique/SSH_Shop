package edson.web.shop.cart;

import edson.web.shop.product.Product;

/**
 * 购物项实体
 * @author edson
 *
 */
public class CartItem {

	private Product product;
	private int count;//商品数量
	private double sum;//小计
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSum() {
		return count*product.getShop_price();
	}
	
	
	
	
}
