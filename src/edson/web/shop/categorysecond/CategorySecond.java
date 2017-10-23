package edson.web.shop.categorysecond;

import java.util.Set;

import edson.web.shop.category.Category;
import edson.web.shop.product.Product;

/**
 * 二级分类
 * @author Acer
 *
 */
public class CategorySecond {

	private Integer id;
	private String name;
	
	private Category cfirst;//一级分类
	private Set<Product> products;
	
	public final Set<Product> getProducts() {
		return products;
	}
	public final void setProducts(Set<Product> products) {
		this.products = products;
	}
	public final Integer getId() {
		return id;
	}
	public final void setId(Integer id) {
		this.id = id;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final Category getCfirst() {
		return cfirst;
	}
	public final void setCfirst(Category cfirst) {
		this.cfirst = cfirst;
	}
	public CategorySecond(Integer id, String name, Category cfirst,
			Set<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.cfirst = cfirst;
		this.products = products;
	}
	public CategorySecond() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
