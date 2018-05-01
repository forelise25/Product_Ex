package exam.product.vo;

import java.util.Date;

public class ProductVO {
	private String id;
	private String name;
	private int price;
	private Date registerDate;
	
	public ProductVO(String id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public String toString() {
		return "제품정보 [ id ="+id +", name+"+name+", price"+price+", registderDate = "+registerDate+"]";
	}
	
}
