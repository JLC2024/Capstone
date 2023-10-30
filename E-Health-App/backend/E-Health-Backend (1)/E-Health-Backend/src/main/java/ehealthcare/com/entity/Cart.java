package ehealthcare.com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cart {
	
	@Id
	@Column(name="emailid", nullable = false, insertable = true)
	String emailid;
	
	
	@ManyToOne
    Login customer;
	
	 @ManyToOne
	 @JoinColumn(name = "mid", referencedColumnName = "mid")
	 Medicine medrequest;
	 
	Integer quantity;
	
	public Cart() {
		
	}
	
	public Cart(String emailid, Login customer, Medicine medrequest, Integer quantity) {
		super();
		this.emailid=emailid;
		this.customer=customer;
		this.medrequest=medrequest;
		this.quantity=quantity;
	}
	
	public Cart(Login customer, Medicine medrequest, Integer quantity) {
		this.customer=customer;
		this.medrequest=medrequest;
		this.quantity=quantity;
	}
	
	 
		public String getEmailid() {
			return emailid;
		}
		
		public void setEmailid(String emailid) {
			this.emailid=emailid;
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
			return "Cart [emailid=" + emailid + ", customer=" + customer + ", medrequest=" + medrequest + ", quantity="
					+ quantity + "]";
		}
	
	

}
