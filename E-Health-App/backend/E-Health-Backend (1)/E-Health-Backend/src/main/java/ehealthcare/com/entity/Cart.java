package ehealthcare.com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer cartid;
	
	@ManyToOne
    @JoinColumn(name = "emailid", referencedColumnName = "emailid")
    Login customer;
	
	 @ManyToOne
	 @JoinColumn(name = "mid", referencedColumnName = "mid")
	 Medicine medrequest;
	 
	Integer quantity;
	
	public Cart() {
		
	}
	
	public Cart(Login customer, Medicine medrequest, Integer quantity) {
		super();
		this.customer=customer;
		this.medrequest=medrequest;
		this.quantity=quantity;
	}
	
	 public Integer getCartid() {
	        return cartid;
	    }

	    public void setCartid(Integer cartid) {
	        this.cartid = cartid;
	    }

	    public Login getCustomer() {
	        return customer;
	    }

	    public void setCustomer(Login customer) {
	        this.customer = customer;
	    }

	    public Medicine getMedrequest() {
	        return medrequest;
	    }

	    public void setMedrequest(Medicine medrequest) {
	        this.medrequest = medrequest;
	    }

	    public Integer getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(Integer quantity) {
	        this.quantity = quantity;
	    }

		@Override
		public String toString() {
			return "Cart [cartid=" + cartid + ", customer=" + customer + ", medrequest=" + medrequest + ", quantity="
					+ quantity + "]";
		}
	
	

}
