package edson.web.shop.admin.user;
/**
 * 后台用户实体类
 * @author Edson
 *
 */
public class AdminUser {

	private Integer id;
	private String username;
	private String password;
	public final Integer getId() {
		return id;
	}
	public final void setId(Integer id) {
		this.id = id;
	}
	public final String getUsername() {
		return username;
	}
	public final void setUsername(String username) {
		this.username = username;
	}
	public final String getPassword() {
		return password;
	}
	public final void setPassword(String password) {
		this.password = password;
	}
	
	
}
