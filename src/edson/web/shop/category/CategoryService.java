package edson.web.shop.category;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import edson.web.shop.exception.DaoException;

@Transactional
public class CategoryService {
	
	private CategoryDao cdao;

	public List<Category> findAllCategory() throws DaoException {
		return cdao.findAllCategory();
	}

	public final void setCdao(CategoryDao cdao) {
		this.cdao = cdao;
	}

	public void addCategory(Category category) {
		cdao.addCategory(category);
	}

	public void updateCategory(Category category) {
		cdao.updateCategory(category);
	}

	public void deleteCategory(Category category) {
		cdao.deleteCategory(category);
	}

	
}
