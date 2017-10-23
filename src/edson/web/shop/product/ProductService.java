package edson.web.shop.product;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import edson.web.shop.category.Category;
import edson.web.shop.categorysecond.CategorySecond;
import edson.web.shop.exception.DaoException;
import edson.web.shop.utils.PageBean;
@Transactional
public class ProductService {
	
	private ProductDao pdao;

	public List<Product> findByHot() throws DaoException {
		return pdao.findByHot();
	}

	public final void setPdao(ProductDao pdao) {
		this.pdao = pdao;
	}

	public List<Product> findByNew() throws DaoException {
		return pdao.findByNew();
	}

	public List<Category> findAllFirstCateory() throws DaoException {
		return pdao.findAllFirstCateory();
	}

	public Product findById(Integer id) throws DaoException {
		return pdao.findById(id);
	}

	public PageBean<Product> viewAllProduct(Integer pagenum) throws DaoException {
		return pdao.viewAllProduct(pagenum);
	}

	public List<CategorySecond> findAllSecondCategory() {
		return pdao.findAllCategorySecond();
	}

	public void saveProduct(Product product) {
		pdao.saveProduct(product);
	}

	public CategorySecond findCategorySecondById(Integer id) {
		return pdao.findCategorySecondById(id);
	}

	public void updateProduct(Product product) {
		pdao.updateProduct(product);
	}

	public void deleteProduct(Product product) {
		pdao.deleteProduct(product);
	}
	
	

}
