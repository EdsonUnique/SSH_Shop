package edson.web.shop.categorysecond;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edson.web.shop.category.Category;
import edson.web.shop.product.Product;
import edson.web.shop.utils.PageBean;


/**
 * 二级分类
 * @author Acer
 *
 */
public class CategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond>{

	private CategorySecondService csservice;
	private List<Category> fss;//一级分类及其二级分类
	private PageBean<Product> page;//分页查询
	private String fid;//记住一级分类id
	private String sid;
	private CategorySecond cs=new CategorySecond();
	/**
	 * 查询二级分类
	 * @return
	 */
	public String searchSecondCategory(){
		try{
			//根据一级分类id查找二级分类及其商品
			fid=ServletActionContext.getRequest().getParameter("first_id");
			String pagenum=ServletActionContext.getRequest().getParameter("pagenum");
			if(pagenum==null ||pagenum.trim().equals("") || Integer.valueOf(pagenum)<=0)pagenum="1";
			page=csservice.findByFirstId(fid,Integer.valueOf(pagenum));
			
			//查找所有一级分类
			fss=csservice.findAllFirstCateory();
			
			return "success_searchSecondCategory";
			
		}catch (Exception e) {
			e.printStackTrace();
			this.addActionError("服务器内部错误，请稍后尝试！");
			return "success_message";
		}
		
	}
	
	//根据二级分类查询
	public String searchDetailSecondCategory(){
		try{
			//根据一级分类id查找二级分类及其商品
			sid=ServletActionContext.getRequest().getParameter("second_id");
			String pagenum=ServletActionContext.getRequest().getParameter("pagenum");
			if(pagenum==null || Integer.valueOf(pagenum)<=0)pagenum="1";
			page=csservice.findBySecondId(sid,Integer.valueOf(pagenum));
			
			//查找所有一级分类
			fss=csservice.findAllFirstCateory();
			
			return "success_searchDetailSecondCategory";
			
		}catch (Exception e) {
			e.printStackTrace();
			this.addActionError("服务器内部错误，请稍后尝试！");
			return "success_message";
		}
	}
	
	//后台查询所有二级分类
	private PageBean<CategorySecond> pb;
	
	public String viewAllCategorySecond(){
		try{
			String pagenum=ServletActionContext.getRequest().getParameter("pagenum");
			if(pagenum==null)pagenum="1";
			pb=csservice.findAllCategorySecond(Integer.valueOf(pagenum));
			
			return "success_viewAllCategorySecond";
		}catch (Exception e) {
			e.printStackTrace();
			this.addActionError("服务器内部错误，请稍后尝试！");
			return "success_message";
		}
	}
	
	/**
	 * 后台添加二级分类
	 * @return
	 */
	public String addCategorySecond(){
		Category cfirst=csservice.findFirstCategory(fid);
		cs.setCfirst(cfirst);
		csservice.addCategorySecond(cs);
		
		return "success_addCategorySecond";
	}
	
	public String addCategorySecondUI(){
		try{
			//查询所有一级分类，用于二级分类的添加
			fss=csservice.findAllFirstCateory();
			return "success_addCategorySecondUI";
		}catch (Exception e) {
			e.printStackTrace();
			this.addActionError("服务器内部错误，请稍后尝试！");
			return "success_message";
		}
	}
	
	public String updateCategorySecond(){
		Category cfirst=csservice.findFirstCategory(fid);
		cs.setCfirst(cfirst);
		csservice.updateCategorySecond(cs);
		
		return "success_updateCategorySecond";
	}
	
	public String updateCategorySecondUI(){
		try{
			//查询所有一级分类，用于二级分类的添加
			fss=csservice.findAllFirstCateory();
			cs=csservice.findCategorySecond(sid);
			return "success_updateCategorySecondUI";
		}catch (Exception e) {
			e.printStackTrace();
			this.addActionError("服务器内部错误，请稍后尝试！");
			return "success_message";
		}
	}
	
	public String deleteCategorySecond(){
		csservice.deleteCategorySecond(cs);
		
		return "success_deleteCategorySecond";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public final void setCsservice(CategorySecondService csservice) {
		this.csservice = csservice;
	}

	public final List<Category> getFss() {
		return fss;
	}

	public final void setFss(List<Category> fss) {
		this.fss = fss;
	}

	public final PageBean getPage() {
		return page;
	}

	public final void setPage(PageBean page) {
		this.page = page;
	}

	public final String getFid() {
		return fid;
	}

	public final String getSid() {
		return sid;
	}

	public final void setSid(String sid) {
		this.sid = sid;
	}

	public final void setFid(String fid) {
		this.fid = fid;
	}

	public final PageBean<CategorySecond> getPb() {
		return pb;
	}

	public final void setPb(PageBean<CategorySecond> pb) {
		this.pb = pb;
	}

	@Override
	public CategorySecond getModel() {
		// TODO Auto-generated method stub
		return cs;
	}
	
	

	
	
	
	
}
