package edson.web.shop.orders;


import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edson.web.shop.cart.Cart;
import edson.web.shop.cart.CartItem;
import edson.web.shop.user.User;
import edson.web.shop.utils.PageBean;
import edson.web.shop.utils.PaymentUtil;

public class OrderAction extends ActionSupport implements ModelDriven<Order>{
	
	private OrderService oservice;
	private Order order=new Order();
	private List<Order> orders;
	private String pd_FrpId;  //银行编号
	private PageBean<Order> order_pb;
	
	//接收支付成功后的参数
	private String r1_Code;//支付结果  1表示成功
	private String r3_Amt;//支付金额
	private String  r6_Order;//订单号
	
	public String saveOrder(){
		try{
			//获取购物车对象
			Cart cart=(Cart) ActionContext.getContext().getSession().get("cart");
			User user=(User) ActionContext.getContext().getSession().get("user");
			
			if(user==null){
				//未登录
				return "success_loginUI";
			}
			
			//创建订单实体
			order.setUser(user);
			order.setState(0);//0 未付款 1 已付款  2 未发货  3 已发货  
			order.setTime(new Date().toLocaleString());
			order.setAddress(user.getAddress());
			order.setTotalprice(cart.getTotalprice());
			
			//创建订单项
			for(CartItem ct:cart.getMap().values()){
				OrderItem oi=new OrderItem();
				oi.setCount(ct.getCount());
				oi.setOrder(order);
				oi.setProduct(ct.getProduct());
				oi.setSum(ct.getSum());
				order.getItems().add(oi);
			}
			
			//订单插入数据库------级联插入
			oservice.saveOrder(order);
			//删除订单后，应删除原来购物车的货物
			cart.emptyCart();
			
			
			return "success_saveOrder";
		}catch (Exception e) {
			e.printStackTrace();
			this.addActionError("服务器内部错误，请稍后尝试！");
			return "success_message";
		}
	}
	
	//查询用户所有订单
	public String showOrders(){
		try{
			User user=(User) ActionContext.getContext().getSession().get("user");
			
			orders=oservice.findByUserId(user.getId());
			
			return "success_showOrders";
			
		}catch (Exception e) {
			e.printStackTrace();
			this.addActionError("服务器内部错误，请稍后尝试！");
			return "success_message";
		}
	}
	
	//订单支付
	public String payOrder(){
		try{
			//支付订单(重定向到支付网关)，拼接字符串
			order=oservice.findByOrderId(order.getId());
			String  p0_Cmd="Buy";
			String  p1_MerId="10001126856";
			String  p2_Order=order.getId().toString();
			String  p3_Amt="0.01";
			String  p4_Cur="CNY";
			String  p5_Pid="";
			String  p6_Pcat="";
			String  p7_Pdesc="";
			String  p8_Url="http://192.168.56.1:8080/order/order_callBack";//设置回调
			String  p9_SAF="0";
			String  pa_MP="";
			String  pr_NeedResponse="1";
			String keyValue="69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
			String hmac=PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue);
			
			//访问支付网关
			StringBuffer sb=new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
			sb.append("p0_Cmd="+p0_Cmd+"&").append("p1_MerId="+p1_MerId+"&");
			sb.append("p2_Order="+p2_Order+"&").append("p3_Amt="+p3_Amt+"&");
			sb.append("p4_Cur="+p4_Cur+"&").append("p5_Pid="+p5_Pid+"&");
			sb.append("p6_Pcat="+p6_Pcat+"&").append("p7_Pdesc="+p7_Pdesc+"&");
			sb.append("p8_Url="+p8_Url+"&").append("p9_SAF="+p9_SAF+"&");
			sb.append("pa_MP="+pa_MP+"&").append("pd_FrpId="+pd_FrpId+"&");
			sb.append("pr_NeedResponse="+pr_NeedResponse+"&").append("keyValue="+keyValue+"&");
			sb.append("hmac="+hmac);
			
			//支付成功后跳转到指定Action,修改订单状态
			ServletActionContext.getResponse().sendRedirect(sb.toString());
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			this.addActionError("服务器内部错误，请稍后尝试！");
			return "success_message";
		}
	}
	
	public String callBack(){
		//设置订单支付成功后的回调函数
		//修改订单状态
		if("1".equals(r1_Code)){
			//支付成功
			order.setState(1);
			oservice.updateOrder(order);
			
			this.addActionMessage("支付成功！订单号："+r6_Order+"  支付金额:"+r3_Amt);
			return "success_message";
		}
		
		this.addActionMessage("支付失败！订单号："+r6_Order+"  支付金额:"+r3_Amt);
		return "success_message";
		
	}
	
	/**
	 * 未付款状态跳转到付款页面
	 * @return
	 */
	public String repayOrder(){
		try{
			
			order=oservice.findByOrderId(order.getId());
			return "success_repayOrder";
		}catch (Exception e) {
			e.printStackTrace();
			this.addActionError("服务器内部错误，请稍后尝试！");
			return "success_message";
		}
	}
	
	/**
	 * 查看数据库中所有订单
	 * 分页查询
	 * @return
	 */
	public String viewAllOrders(){
		try{
			String pagenum=ServletActionContext.getRequest().getParameter("pagenum");
			if(pagenum==null)pagenum="1";
			order_pb=oservice.viewAllOrders(Integer.valueOf(pagenum));
			return "success_viewAllOrders";
		}catch (Exception e) {
			e.printStackTrace();
			this.addActionError("服务器内部错误，请稍后尝试！");
			return "success_message";
		}
	}
	
	/**
	 * 后台查看订单详情
	 * @return
	 */
	public String viewOrderItem(){
		order=oservice.findOrder(order.getId());
		return "success_viewOrderItem";
	}
	
	/**
	 * 后台修改订单状态
	 * @return
	 */
	public String updateOrder(){
		//传参订单id和状态
		oservice.updateOrder(order);
		return "success_updateOrder";
	}
	
	public String updateOrderUI(){
		return "success_updateOrderUI";
	}
	
	public String deleteOrder(){
		
		oservice.deleteOrder(order);
		return "success_deleteOrder";
	}
	
	
	
	
	public final PageBean<Order> getOrder_pb() {
		return order_pb;
	}

	public final void setOrder_pb(PageBean<Order> order_pb) {
		this.order_pb = order_pb;
	}

	public final String getPd_FrpId() {
		return pd_FrpId;
	}

	public final void setPd_FrpId(String pd_FrpId) {
		this.pd_FrpId = pd_FrpId;
	}

	public final void setOservice(OrderService oservice) {
		this.oservice = oservice;
	}
	public final Order getOrder() {
		return order;
	}

	public final List<Order> getOrders() {
		return orders;
	}

	public final void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public final String getR1_Code() {
		return r1_Code;
	}

	public final void setR1_Code(String r1_Code) {
		this.r1_Code = r1_Code;
	}

	public final String getR3_Amt() {
		return r3_Amt;
	}

	public final void setR3_Amt(String r3_Amt) {
		this.r3_Amt = r3_Amt;
	}

	public final String getR6_Order() {
		return r6_Order;
	}

	public final void setR6_Order(String r6_Order) {
		this.r6_Order = r6_Order;
	}

	@Override
	public Order getModel() {
		return order;
	}
	
	
	

}
