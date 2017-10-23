package edson.web.shop.index;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import edson.web.shop.category.Category;
import edson.web.shop.category.CategoryService;
import edson.web.shop.product.Product;
import edson.web.shop.product.ProductService;


public class ShopIndex extends ActionSupport{

	private CategoryService cservice;
	private ProductService pservice;
	private List<Product> products_hot;
	private List<Product> products_new;
	
	/**
	 * 首页
	 * @return
	 */
	public String showIndex(){
		try{
			//展示一级分类
			List<Category> categories=cservice.findAllCategory();
			ServletActionContext.getContext().getSession().put("categories", categories);
			
			//查找热门商品
			products_hot=pservice.findByHot();
			
			//查找最新商品
			products_new=pservice.findByNew();
			
			return "indexSuccess";
		}catch (Exception e) {
			e.printStackTrace();
			this.addActionError("服务器内部错误，请稍后尝试！");
			return "success_message";
		}
		
	}
	
	
	
	
	public final void setCservice(CategoryService cservice) {
		this.cservice = cservice;
	}

	public final void setPservice(ProductService pservice) {
		this.pservice = pservice;
	}
	
	public final List<Product> getProducts_hot() {
		return products_hot;
	}

	public final void setProducts_hot(List<Product> products_hot) {
		this.products_hot = products_hot;
	}




	public final List<Product> getProducts_new() {
		return products_new;
	}




	public final void setProducts_new(List<Product> products_new) {
		this.products_new = products_new;
	}
	
	
	
	
	

	
	
	
}
