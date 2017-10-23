package edson.web.shop.user;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edson.web.shop.exception.DaoException;

@Transactional
public class UserService{

	private UserDao udao;
	
	public void addUser(User user) throws DaoException {
		udao.addUser(user);
	}

	public final void setUdao(UserDao udao) {
		this.udao = udao;
	}

	public User activateAccount(String code) throws DaoException {
		return udao.activateAccount(code);
		
	}

	public void updateUser(User new_user) throws DaoException {
		udao.updateUser(new_user);
		
	}

	public User findUser(String username, String password) throws DaoException {
		return udao.findUser(username,password);
	}

	public User findByUsername(String username) throws DaoException {
		return udao.findUser(username);
	}
	
	

}
