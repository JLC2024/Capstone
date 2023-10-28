package ehealthcare.com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medicine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mid;
	private String mname;
	private float price;
	private int qty;
	private String imageurl;
	private String description;
	
	public Medicine() {
		
	}
	public Medicine(String mname, float price, int qty, String imageurl, String description) {
		super();
		this.mname=mname;
		this.price=price;
		this.qty=qty;
		this.imageurl=imageurl;
		this.description=description;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String desc) {
		this.description = desc;
	}
	@Override
	public String toString() {
		return "Medicine [mid=" + mid + ", mname=" + mname + ", price=" + price + ", qty=" + qty + ", imageurl="
				+ imageurl + ", description=" + description + "]";
	}
	
}
