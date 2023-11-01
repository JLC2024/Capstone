package ehealthcare.com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MedicationOrder {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String medicineName;
    private String price;
    private Integer quantity;
    private String fullName;
    private String phoneNumber;
    private String address;
    private String contactMethod;
    private String additionalComments;
    private boolean approved;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Login user;

    public MedicationOrder() {
    	
    }
	public MedicationOrder(Long id, String medicineName, String price, Integer quantity, String fullName, String phoneNumber, String address, String contactMethod, String additionalComments,
			Login user, boolean approved) {
		super();
		this.id = id;
		this.medicineName = medicineName;
		this.price = price;
		this.quantity = quantity;
		this.fullName=fullName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.contactMethod = contactMethod;
		this.additionalComments=additionalComments;
		this.user = user;
		this.approved = approved;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactMethod() {
		return contactMethod;
	}

	public void setContactMethod(String contactMethod) {
		this.contactMethod = contactMethod;
	}

	public Login getUser() {
		return user;
	}

	public void setUser(Login user) {
		this.user = user;
	}

	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public String getAdditionalComments() {
		return additionalComments;
	}
	public void setAdditionalComments(String additionalComments) {
		this.additionalComments = additionalComments;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	@Override
	public String toString() {
		return "MedicationOrder [id=" + id + ", medicineName=" + medicineName + ", price=" + price + ", quantity="
				+ quantity + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", contactMethod=" + contactMethod + ", additionalComments=" + additionalComments + ", approved="
				+ approved + ", user=" + user + "]";
	}
	
	
	
	
	

    
    
}
