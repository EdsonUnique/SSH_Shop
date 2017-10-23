package edson.web.shop.admin.user;

import java.util.List;

public class AdminUserService {
	
	private AdminUserDao udao;

	public AdminUser findAdminUser(AdminUser user) {
		return udao.findAdminUser(user);
	}

	public final void setUdao(AdminUserDao udao) {
		this.udao = udao;
	}

	public List<AdminUser> findAllAdminUser() {
		return udao.findAllAdminUsers();
	}

	public void addAdminUser(AdminUser user) {
		udao.addAdminUser(user);
	}

	public void deleteAdminUser(AdminUser user) {
		udao.deleteAdminUser(user);
		
	}

	public void updateAdminUser(AdminUser user) {
		udao.updateAdminUser(user);
	}
	
	

}
