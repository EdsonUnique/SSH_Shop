package edson.web.shop.user;

import java.util.Set;

import edson.web.shop.orders.Order;

public class User {
	
	private Integer id;
	private String username;
	private String password;
	private String email;
	private String realname;
	private String gender;
	private String phone;
	private String address;
	private Integer state;		//用户状态，是否激活
	private String code;		//激活码
	
	private Set<Order> orders;
	
	public final Set<Order> getOrders() {
		return orders;
	}
	public final void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
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
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	public final String getRealname() {
		return realname;
	}
	public final void setRealname(String realname) {
		this.realname = realname;
	}
	public final String getGender() {
		return gender;
	}
	public final void setGender(String gender) {
		this.gender = gender;
	}
	public final String getPhone() {
		return phone;
	}
	public final void setPhone(String phone) {
		this.phone = phone;
	}
	public final String getAddress() {
		return address;
	}
	public final void setAddress(String address) {
		this.address = address;
	}
	public final Integer getState() {
		return state;
	}
	public final void setState(Integer state) {
		this.state = state;
	}
	public final String getCode() {
		return code;
	}
	public final void setCode(String code) {
		this.code = code;
	}
	
	
}
