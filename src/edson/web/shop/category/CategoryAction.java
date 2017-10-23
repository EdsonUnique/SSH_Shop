package edson.web.shop.category;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CategoryAction extends ActionSupport implements ModelDriven<Category>{
	
	private CategoryService cservice;
	private Category category=new Category();
	private List<Category> categories;
	/**
	 * 后台查看所有一级分类
	 * @return
	 */
	public String viewAllCategory(){
		try{
			
			categories=cservice.findAllCategory();
			if(categories==null || categories.size()<=0){
				this.addActionMessage("系统中还未有任何一级分类！");
			}
			return "success_viewAllCategory";
		}catch (Exception e) {
			e.printStackTrace();
			this.addActionMessage("服务器内部错误，请稍后尝试！");
			return "success_message";
		}
	}
	
	public String addCategory(){
		cservice.addCategory(category);
		return "success_addCategory";
	}
	
	public String addCategoryUI(){
		return "success_addCategoryUI";
	}
	public String updateCategoryUI(){
		return "success_updateCategoryUI";
	}
	public String updateCategory(){
		cservice.updateCategory(category);
		return "success_updateCategory";
	}
	
	public String deleteCategory(){
		cservice.deleteCategory(category);
		return "success_deleteCategory";
	}
	
	
	
	
	
	

	public final List<Category> getCategories() {
		return categories;
	}







	public final void setCategories(List<Category> categories) {
		this.categories = categories;
	}







	public final void setCservice(CategoryService cservice) {
		this.cservice = cservice;
	}

	@Override
	public Category getModel() {
		return category;
	}
	
	

}
