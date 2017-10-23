package edson.web.shop.admin.user;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 后台用户action
 * @author Acer
 *
 */
public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser>{
	
	private AdminUser user=new AdminUser();
	private AdminUserService uservice;
	private List<AdminUser> adminUsers;
	
	public String adminLogin(){
		
		AdminUser a_user=uservice.findAdminUser(user);
		if(a_user==null){
			//用户不存在
			this.addActionError("用户名或密码错误！");
			return "login_input";
		}
		ActionContext.getContext().getSession().put("adminUser", a_user);
		return "success_adminLogin";
	}
	
	public String listAdminUser(){
		//查看所有用户
		adminUsers=uservice.findAllAdminUser();
		if(adminUsers==null || adminUsers.size()<=0){
			this.addActionMessage("系统还未有任何用户！");
		}
		return "success_listAdminUser";
	}
	
	public String addAdminUserUI(){
		return "success_addAdminUserUI";
	}
	
	public String addAdminUser(){
		uservice.addAdminUser(user);
		return "success_addAdminUser";
	}
	
	public String deleteAdminUser(){
		uservice.deleteAdminUser(user);
		return "success_deleteAdminUser";
	}
	
	public String updateAdminUser(){
		uservice.updateAdminUser(user);
		return "success_updateAdminUser";
	}
	
	public String updateAdminUserUI(){
		return "success_updateAdminUserUI";
	}
	
	
	

	@Override
	public AdminUser getModel() {
		return user;
	}

	public final void setUservice(AdminUserService uservice) {
		this.uservice = uservice;
	}

	public final List<AdminUser> getAdminUsers() {
		return adminUsers;
	}

	public final void setAdminUsers(List<AdminUser> adminUsers) {
		this.adminUsers = adminUsers;
	}

	
}
