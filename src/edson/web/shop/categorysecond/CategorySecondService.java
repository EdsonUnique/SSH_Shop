package edson.web.shop.categorysecond;

import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import edson.web.shop.category.Category;
import edson.web.shop.exception.DaoException;
import edson.web.shop.product.Product;
import edson.web.shop.utils.PageBean;

/**
 * 二级分类
 * @author Acer
 *
 */
@Transactional
public class CategorySecondService {

	private CategorySecondDao csdao;
	
	public PageBean<Product> findByFirstId(String fid, Integer pagenum) throws DaoException {
		
		return csdao.findByFirstId(fid,pagenum);
	}

	public final void setCsdao(CategorySecondDao csdao) {
		this.csdao = csdao;
	}

	public List<Category> findAllFirstCateory() throws DaoException {
		return csdao.findAllFirstCateory();
	}

	public PageBean<Product> findBySecondId(String sid, Integer pagenum) throws DaoException {
		return csdao.findBySecondId(sid,pagenum);
		
	}

	public PageBean<CategorySecond> findAllCategorySecond(Integer pagenum) throws DaoException {
		
		return csdao.findAllCategorySecond(pagenum);
	}

	/**
	 * 查找一级分类
	 * @param fid 一级分类id
	 * @return
	 */
	public Category findFirstCategory(String fid) {
		return csdao.findFirstCategory(fid);
	}

	public void addCategorySecond(CategorySecond cs) {
		csdao.addCategorySecond(cs);
	}

	public void updateCategorySecond(CategorySecond cs) {
		csdao.updateCategorySecond(cs);
	}

	public CategorySecond findCategorySecond(String sid) {
		return csdao.findCategorySecond(sid);
	}

	public void deleteCategorySecond(CategorySecond cs) {
		csdao.deleteCategorySecond(cs);
	}
	
	
	
	
	
	
}
