package edson.web.shop.cart;

import java.util.HashMap;
import java.util.Map;

/**
 * 购物车实体
 * @author edson
 *
 */
public class Cart {

	private Map<Integer,CartItem>map=new HashMap<Integer,CartItem>();  //商品项集合，以商品id为键
	private double totalprice;//总价
	
	//提供购物车相应的操作方法
	public void addCart(CartItem ct){
		//将商品添加到购物车
		if(map.containsKey(ct.getProduct().getId())){
			//已存在该商品
			CartItem old_ct=map.get(ct.getProduct().getId());
			old_ct.setCount(old_ct.getCount()+ct.getCount());
		}else{
			map.put(ct.getProduct().getId(), ct);
		}
		
	}
	
	public void deleteCartItem(String ctId){
		//删除购物项
		map.remove(Integer.valueOf(ctId));
		
		
	}
	
	public void emptyCart(){
		//清空购物车
		map.clear();
		
	}
	

	public final Map<Integer, CartItem> getMap() {
		return map;
	}
	public final void setMap(Map<Integer, CartItem> map) {
		this.map = map;
	}
	
	public final double getTotalprice() {
		totalprice=0;
		if(map!=null){
			for(CartItem ct:map.values()){
				totalprice+=ct.getSum();
			}
		}
		
		return totalprice;
	}

	
	
	
	
}
