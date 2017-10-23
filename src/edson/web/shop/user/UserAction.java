package edson.web.shop.user;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

import edson.web.shop.exception.DaoException;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	private User user=new User();
	private UserService uservice;
	private String imageCode;		//获取随机验证码
	
	public String registerUI(){
		return "success_registerUI";
	}
	
	public String loginUI(){
		return "success_loginUI";
	}
	
	@InputConfig(resultName="input_register")//验证失败后跳转的页面
	public String register(){
		try {
			String strCode=(String) ServletActionContext.getRequest().getSession().getAttribute("imageCode");
			if(imageCode==null || !imageCode.equalsIgnoreCase(strCode)){
				this.addFieldError("imageCode", "验证码错误");
				return "input_register";
			}
			
			uservice.addUser(user);
			this.addActionMessage("您已注册成功，请登录注册邮箱激活帐户。");
		} catch (DaoException e) {
			e.printStackTrace();
			this.addActionMessage("服务器内部错误，请稍后尝试！");
		}
		return "success_message";
	}

	public String activateAccount(){//激活帐户，跳转到登陆页面
		
		try {
			//传过来的参数code激活码封装在user的属性中
			User new_user=uservice.activateAccount(user.getCode());
			
			if(new_user==null){
				this.addActionMessage("激活失败，请重新注册！");
				return "success_message";
			}
			
			//找到则更新用户状态
			new_user.setState(1);
			uservice.updateUser(new_user);
			this.addActionMessage("激活成功，请重新登录！");
			return "success_message";
		
		} catch (DaoException e) {
			e.printStackTrace();
			this.addActionMessage("服务器内部错误，请稍后尝试！");
			return "success_message";
		}
		
	}
	
	@InputConfig(resultName="input_login")
	public String login(){
		try{
			//验证码匹配
			String strCode=(String) ServletActionContext.getRequest().getSession().getAttribute("imageCode");
			if(imageCode==null || !imageCode.equalsIgnoreCase(strCode)){
				this.addFieldError("imageCode", "验证码错误");
				return "input_login";
			}
			
			//用户名登录
			User new_user=uservice.findUser(user.getUsername(),user.getPassword());
			
			if(new_user==null){//未找到
				this.addActionError("用户名或密码错误");
				return "input_login";
			}
			
			//找到则判断用户是否已激活
			if(new_user.getState()==0){
				this.addActionError("账户未激活");
				return "input_login";
			}
			
			//登录成功,跳转到首页
			ServletActionContext.getRequest().getSession().setAttribute("user", new_user);
			return "success_login";
			
		} catch (DaoException e) {
			e.printStackTrace();
			this.addActionMessage("服务器内部错误，请稍后尝试！");
			return "success_message";
		}
	}
	
	//退出登录
	public String logout(){
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		return "success_logout";
	}
	
	
	//产生随机认证图片
	public String generateCheckImage() throws IOException{
		
		int WIDTH=130;
		int HEIGHT=35;
		
		//创建图片
		BufferedImage image=new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		//设置画笔
		Graphics2D g=(Graphics2D) image.getGraphics();
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.setColor(Color.BLUE);
		g.drawRect(1, 1, WIDTH-2, HEIGHT-2);
		
		g.setColor(Color.GRAY);
		for(int i=0;i<5;i++){
			int x1=new Random().nextInt(WIDTH);
			int y1=new Random().nextInt(HEIGHT);
			
			int x2=new Random().nextInt(WIDTH);
			int y2=new Random().nextInt(HEIGHT);
			
			g.drawLine(x1, y1, x2, y2);
			
		}
		
		//字体旋转使用Graphics2D类
		g.setColor(Color.RED);
		g.setFont(new Font("宋体",Font.BOLD,20));
		
		String code="";
		String str="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		int x=5;
		for(int i=0;i<4;i++){
			int rand = (int) (Math.random() * str.length());
			Double angle=new Random().nextDouble()*30*Math.PI/180;//旋转角度
			String c=str.charAt(rand)+"";
			code+=c;		//记住验证码
			g.rotate(angle, x, 20);
			g.drawString(c, x, 20);
			g.rotate(-angle, x, 20);		//转回去，消除旋转
			x+=30;
		}
		
		//将验证码存到Session中
		ActionContext.getContext().getSession().put("imageCode", code);
		
		//输出
		ServletActionContext.getResponse().setDateHeader("expires", -1);
		ServletActionContext.getResponse().setHeader("cache-control", "no-cache");
		ServletActionContext.getResponse().setHeader("pragma", "no-cache");//使浏览器不缓存图片
		ServletActionContext.getResponse().setContentType("image/jpeg");
		ImageIO.write(image, "jpg", ServletActionContext.getResponse().getOutputStream());

		return null;
	}
	
	//Ajax检验用户名是否已存在
	public String checkUsername() throws DaoException, IOException{
		
		User new_user=uservice.findByUsername(user.getUsername());
		if(new_user!=null){
			PrintWriter pw=ServletActionContext.getResponse().getWriter();
			pw.write("用户名已存在！");
			pw.flush();
			pw.close();
		}
		
		return null;
	}
	
	//set/get方法
	public final void setUservice(UserService uservice) {
		this.uservice = uservice;
	}

	@Override
	public User getModel() {
		return user;
	}

	public final void setImageCode(String imageCode) {
		this.imageCode = imageCode;
	}
	
	

}
