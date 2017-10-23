package edson.web.shop.product;

import java.util.Set;

import edson.web.shop.categorysecond.CategorySecond;

public class Product {

	private Integer id;
	private String name;
	private Double market_price;
	private Double shop_price;
	private String description;
	private String image;
	private String date;
	private	String is_hot;		//是否为热门商品
	
	private CategorySecond csecond;

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final Double getMarket_price() {
		return market_price;
	}

	public final void setMarket_price(Double market_price) {
		this.market_price = market_price;
	}

	public final Double getShop_price() {
		return shop_price;
	}

	public final void setShop_price(Double shop_price) {
		this.shop_price = shop_price;
	}

	public final String getDescription() {
		return description;
	}

	public final void setDescription(String description) {
		this.description = description;
	}

	public final String getImage() {
		return image;
	}

	public final void setImage(String image) {
		this.image = image;
	}

	public final String getDate() {
		return date;
	}

	public final void setDate(String date) {
		this.date = date;
	}

	public final String getIs_hot() {
		return is_hot;
	}

	public final void setIs_hot(String is_hot) {
		this.is_hot = is_hot;
	}

	public final CategorySecond getCsecond() {
		return csecond;
	}

	public final void setCsecond(CategorySecond csecond) {
		this.csecond = csecond;
	}

	
	
	
	
}
