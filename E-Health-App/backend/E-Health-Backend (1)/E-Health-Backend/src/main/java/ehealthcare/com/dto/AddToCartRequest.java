package ehealthcare.com.dto;

public class AddToCartRequest {
	 private String emailid;  
	 private Integer mid;   
	 private Integer quantity;

	 public AddToCartRequest() {
		 
	 }
	 public AddToCartRequest(String emailid, Integer mid, Integer quantity) {
		 this.emailid=emailid;
		 this.mid=mid;
		 this.quantity=quantity;
	 }
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "AddToCartRequest [emailid=" + emailid + ", mid=" + mid + ", quantity=" + quantity + "]";
	}
	 
}
