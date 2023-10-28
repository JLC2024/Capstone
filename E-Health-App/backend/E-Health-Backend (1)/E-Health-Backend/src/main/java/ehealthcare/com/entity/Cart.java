package ehealthcare.com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Cart {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cartId;
	
	@ManyToOne
	@JoinColumn(name="medicine_mid")
	private Medicine medicine;
	
	@ManyToOne
	private Login customer;
	
	public Cart() {
		
	}
	public Cart(Medicine medicine, Login customer) {
		super();
		this.medicine=medicine;
		this.customer=customer;
	}
	
	public Integer getCardId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId=cartId;
	}
	
	
	public Medicine getMedicine() {
		return medicine;
	}
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}
	public Login getCustomer() {
		return customer;
	}
	public void setCustomer(Login customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", medicine=" + medicine + ", customer=" + customer + "]";
	}
	public Integer getMedicineId() {
	
		return null;
	}
	
	
	
}
