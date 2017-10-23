package edson.web.shop.category;

import java.util.Set;

import edson.web.shop.categorysecond.CategorySecond;

public class Category {
	
	private Integer id;
	private String name;
	
	private Set<CategorySecond> csecond;		//二级分类
	
	
	public final Set<CategorySecond> getCsecond() {
		return csecond;
	}
	public final void setCsecond(Set<CategorySecond> csecond) {
		this.csecond = csecond;
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
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(Integer id, String name, Set<CategorySecond> csecond) {
		super();
		this.id = id;
		this.name = name;
		this.csecond = csecond;
	}
	
	

}
