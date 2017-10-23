package edson.web.shop.product;

import java.awt.image.ImageFilter;
import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edson.web.shop.category.Category;
import edson.web.shop.categorysecond.CategorySecond;
import edson.web.shop.utils.PageBean;
import edson.web.shop.utils.ShopUtil;

public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	
	private ProductService pservice;
	private List<Category> fss;		//一级分类
	private Product product=new Product();
	private PageBean<Product> product_pb;//商品分页
	private List<CategorySecond> css;//所有二级分类
	private String csid;//二级分类id
	
	//接收上传文件
	private File p_image;
	private String p_imageFileName;

	public String showDetail(){
		try{
			
			//查找所有一级分类
			fss=pservice.findAllFirstCateory();
			
			//查询某一件商品
			product=pservice.findById(product.getId());
			
			return "success_showDetail";
		}catch (Exception e) {
			e.printStackTrace();
			this.addActionError("服务器内部错误，请稍后尝试！");
			return "success_message";
		}
	}
	
	/**
	 * 后台分页显示商品
	 * @return
	 */
	public String viewAllProduct(){
		try{
			String pagenum=ServletActionContext.getRequest().getParameter("pagenum");
			if(pagenum==null)pagenum="1";
			product_pb=pservice.viewAllProduct(Integer.valueOf(pagenum));
			
			
			
			return "success_viewAllProduct";
		}catch (Exception e) {
			e.printStackTrace();
			this.addActionError("服务器内部错误，请稍后尝试！");
			return "success_message";
		}	
	}
	
	public String addProductUI(){
		css=pservice.findAllSecondCategory();
		return "success_addProductUI";
	}
	
	
	public String addProduct(){
		try{
			//接收上传文件，将文件路径存到数据库
			String newFileName=ShopUtil.getUUID()+"_"+p_imageFileName;//避免文件覆盖
			String filePath=ServletActionContext.getServletContext().getRealPath("/products/1")+"/"+newFileName;
			File destFile=new File(filePath);
			FileUtils.copyFile(p_image,destFile);
			String path="products/1/"+newFileName;
			
			//设置二级分类
			if(csid!=null){
				CategorySecond cs=pservice.findCategorySecondById(Integer.valueOf(csid));
				product.setCsecond(cs);
			}else{
				product.setCsecond(null);
			}
			product.setImage(path);
			pservice.saveProduct(product);
			return "success_addProduct";
		}catch (Exception e) {
			e.printStackTrace();
			this.addActionError("服务器内部错误，请稍后尝试！");
			return "success_message";
		}
	}
	
	
	public String updateProductUI(){
		try {
			product=pservice.findById(product.getId());
			css=pservice.findAllSecondCategory();//查询所有二级分类，显示
			return "success_updateProductUI";
		}catch (Exception e) {
				e.printStackTrace();
				this.addActionError("服务器内部错误，请稍后尝试！");
				return "success_message";
		}
	}
	
	
	public String updateProduct(){
		try{
			//先查后修改
			Product a_product=pservice.findById(product.getId());
			
			
			//数据库中有文件，修改时没有上传文件--删除
			if(p_image==null && a_product.getImage()!=null){
				String path=ServletActionContext.getServletContext().getRealPath("/"+a_product.getImage());
				new File(path).delete();
				product.setImage(null);
			}
			
			//数据库有文件，同时上传了文件
			if(a_product.getImage()!=null && p_image!=null){
				String imageName=a_product.getImage().substring(a_product.getImage().lastIndexOf("_")+1);
				if(imageName!=null && !imageName.equals(p_imageFileName)){
					//上传新文件(文件不重名情况下)
					//删除原有文件
					String path=ServletActionContext.getServletContext().getRealPath("/"+a_product.getImage());
					new File(path).delete();
					//上传新文件
					String newFileName=ShopUtil.getUUID()+"_"+p_imageFileName;//避免文件覆盖
					String filePath=ServletActionContext.getServletContext().getRealPath("/products/1")+"/"+newFileName;
					File destFile=new File(filePath);
					FileUtils.copyFile(p_image,destFile);
					product.setImage("products/1/"+newFileName);
				}else{
					//上传同一文件
					product.setImage(a_product.getImage());
				}
				
			}
			
			//数据库没有文件，上传了文件
			if(a_product.getImage()==null && p_image!=null){
				//上传新文件
				String newFileName=ShopUtil.getUUID()+"_"+p_imageFileName;//避免文件覆盖
				String filePath=ServletActionContext.getServletContext().getRealPath("/products/1")+"/"+newFileName;
				File destFile=new File(filePath);
				FileUtils.copyFile(p_image,destFile);
				product.setImage("products/1/"+newFileName);
			}else if(a_product.getImage()==null && p_image==null){
				//数据库没有文件，也没上传文件
				product.setImage(a_product.getImage());
			}
			
			//更新二级分类
			if(csid!=null){
				CategorySecond cs=pservice.findCategorySecondById(Integer.valueOf(csid));
				product.setCsecond(cs);
			}else{
				product.setCsecond(null);
			}
			//修改
			pservice.updateProduct(product);
			
			
			return "success_updateProduct";
		}catch (Exception e) {
			e.printStackTrace();
			this.addActionError("服务器内部错误，请稍后尝试！");
			return "success_message";
		}
	}
	public String deleteProduct(){
		pservice.deleteProduct(product);
		return "success_deleteProduct";
	}
	
	
	

	public final List<Category> getFss() {
		return fss;
	}

	public final void setFss(List<Category> fss) {
		this.fss = fss;
	}

	public final void setPservice(ProductService pservice) {
		this.pservice = pservice;
	}

	@Override
	public Product getModel() {
		return product;
	}

	public final PageBean<Product> getProduct_pb() {
		return product_pb;
	}

	public final void setProduct_pb(PageBean<Product> product_pb) {
		this.product_pb = product_pb;
	}

	public final List<CategorySecond> getCss() {
		return css;
	}

	public final void setCss(List<CategorySecond> css) {
		this.css = css;
	}

	public final String getCsid() {
		return csid;
	}

	public final void setCsid(String csid) {
		this.csid = csid;
	}

	public final File getP_image() {
		return p_image;
	}

	public final void setP_image(File p_image) {
		this.p_image = p_image;
	}

	public final String getP_imageFileName() {
		return p_imageFileName;
	}

	public final void setP_imageFileName(String p_imageFileName) {
		this.p_imageFileName = p_imageFileName;
	}
	
	
	
}
