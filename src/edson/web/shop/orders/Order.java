package edson.web.shop.orders;

import java.util.HashSet;
import java.util.Set;

import edson.web.shop.user.User;

public class Order {
	
	private Integer id;
	private String time;
	private String address;
	private Double totalprice;
	private Integer state;		//订单状态
	private User user;
	
	private Set<OrderItem> items=new HashSet<OrderItem>();//订单项
	
	
	
	public final Integer getId() {
		return id;
	}
	public final void setId(Integer id) {
		this.id = id;
	}
	public final String getTime() {
		return time;
	}
	public final void setTime(String time) {
		this.time = time;
	}
	public final String getAddress() {
		return address;
	}
	public final void setAddress(String address) {
		this.address = address;
	}
	public final Double getTotalprice() {
		return totalprice;
	}
	public final void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}
	public final Integer getState() {
		return state;
	}
	public final void setState(Integer state) {
		this.state = state;
	}
	public final User getUser() {
		return user;
	}
	public final void setUser(User user) {
		this.user = user;
	}
	public final Set<OrderItem> getItems() {
		return items;
	}
	public final void setItems(Set<OrderItem> items) {
		this.items = items;
	}
	
	

}
