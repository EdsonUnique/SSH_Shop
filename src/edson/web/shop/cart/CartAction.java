package edson.web.shop.cart;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edson.web.shop.product.Product;

public class CartAction extends ActionSupport implements ModelDriven<Product>{
	
	private Product product=new Product();//接收页面的商品信息
	
	
	//添加到购物车
	public String addCart(){
		//从session中获取cart
		
		Cart cart=(Cart) ActionContext.getContext().getSession().get("cart");
		Integer count=Integer.valueOf(ServletActionContext.getRequest().getParameter("count"));
		
		if(cart==null){//第一次注册登录
			cart=new Cart();
			ActionContext.getContext().getSession().put("cart", cart);
		}
		
		CartItem ct=new CartItem();
		ct.setProduct(product);
		ct.setCount(count);
		cart.addCart(ct);
		
		return "success_addCart";
	}
	
	/**
	 * 对购物车进行删除和清空
	 * @return
	 */
	public String operateCart(){
		String method=ServletActionContext.getRequest().getParameter("method");
		String ctId=ServletActionContext.getRequest().getParameter("ctId");
		Cart cart=(Cart) ActionContext.getContext().getSession().get("cart");
		
		if("delete".equals(method)){
			//从购物车删除购物项
			cart.deleteCartItem(ctId);
		}
		
		if("empty".equals(method)){
			//清空购物车
			cart.emptyCart();
		}
		
		return "success_operateCart";
	}
	
	public String cartUI(){
		//跳转到购物车页面
		return "success_cartUI";
	}
	
	
	
	


	@Override
	public Product getModel() {
		return product;
	}
	
	

}
