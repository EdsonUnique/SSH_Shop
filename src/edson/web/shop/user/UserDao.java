package edson.web.shop.user;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edson.web.shop.exception.DaoException;
import edson.web.shop.utils.SendEmail;
import edson.web.shop.utils.ShopUtil;

public class UserDao extends HibernateDaoSupport{

	public void addUser(User user) throws DaoException {
		try{
			String code=ShopUtil.getUUID();
			user.setCode(code);
			user.setState(0);		//将用户的状态设为未激活状态
			this.getHibernateTemplate().save(user);
			new SendEmail().sendEmail(user.getEmail(),user.getCode());
		}catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public User activateAccount(String code) throws DaoException {
		try{
			List<User> users=this.getHibernateTemplate().find("from User where code=?",code);
			
			if(users.size()<=0){
				return null;
			}
			
			return users.get(0);
		}catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public void updateUser(User new_user) throws DaoException {
		try{
			this.getHibernateTemplate().update(new_user);
		}catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public User findUser(String username, String password) throws DaoException {
		try{
			List<User> users=this.getHibernateTemplate().find("from User where username=? and password=?", username,password);
			if(users.size()<=0){
				return null;
			}
			
			return users.get(0);
		}catch (Exception e) {
			throw new DaoException(e);
		}
		
	}

	public User findUser(String username) throws DaoException {
		try{
			List<User> users=this.getHibernateTemplate().find("from User where username=?", username);
			if(users.size()<=0){
				return null;
			}
			
			return users.get(0);
		}catch (Exception e) {
			throw new DaoException(e);
		}
	}

}
