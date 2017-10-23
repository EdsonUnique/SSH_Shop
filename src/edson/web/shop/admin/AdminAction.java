package edson.web.shop.admin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edson.web.shop.admin.user.AdminUser;

/**
 * 后台访问页面
 * @author edson
 *
 */
public class AdminAction extends ActionSupport{
	
	
	public String adminBottom(){
		return "success_adminBottom";
	}
	public String adminLeft(){
		return "success_adminLeft";
	}
	public String adminTop(){
		return "success_adminTop";
	}
	public String adminWelcome(){
		return "success_adminWelcome";
	}
	public String adminHome(){
		AdminUser user=(AdminUser) ActionContext.getContext().getSession().get("adminUser");
		if(user==null){
			this.addActionMessage("您还没有登录！");
			return "success_message";
		}
		return "success_adminHome";
	}
	
	//后台用户页面访问
	public String adminUserList(){
		return "success_adminUserList";
	}
	
	//后台一级分类页面访问
	public String adminCategoryList(){
		return "success_adminCategoryList";
	}
	
	
}
