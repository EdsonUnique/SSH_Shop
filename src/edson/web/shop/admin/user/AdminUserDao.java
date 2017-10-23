package edson.web.shop.admin.user;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AdminUserDao extends HibernateDaoSupport{

	public AdminUser findAdminUser(AdminUser user) {
		List<AdminUser> users=this.getHibernateTemplate().find("from AdminUser u where u.username=? and u.password=?",user.getUsername(),user.getPassword());
		if(users==null || users.size()<=0){
			return null;
		}
		return users.get(0);
	}

	public List<AdminUser> findAllAdminUsers() {
		return this.getHibernateTemplate().find("from AdminUser");
		
	}

	public void addAdminUser(AdminUser user) {
		this.getHibernateTemplate().save(user);
	}

	public void deleteAdminUser(AdminUser user) {
		this.getHibernateTemplate().delete(user);
		
	}

	public void updateAdminUser(AdminUser user) {
		this.getHibernateTemplate().update(user);
	}

}
