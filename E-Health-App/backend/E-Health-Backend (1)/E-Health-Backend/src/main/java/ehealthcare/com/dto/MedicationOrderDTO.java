package ehealthcare.com.dto;

public class MedicationOrderDTO {
	private String medicineName;
	private String price;
	private Integer quantity;
	private String fullName;
    private String phoneNumber;
    private String address;
    private String contactMethod;
    private String additionalComments;
    
	public MedicationOrderDTO() {
		  
	  }

	
	public MedicationOrderDTO(String medicineName, String price, Integer quantity, String fullName, String phoneNumber, String address, String contactMethod,
			String additionalComments) {
		super();
		this.medicineName = medicineName;
		this.price=price;
		this.quantity=quantity;
		this.fullName=fullName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.contactMethod = contactMethod;
		this.additionalComments = additionalComments;
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


	public String getAdditionalComments() {
		return additionalComments;
	}


	public void setAdditionalComments(String additionalComments) {
		this.additionalComments = additionalComments;
	}

	

	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
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


	@Override
	public String toString() {
		return "MedicationOrderDTO [medicineName=" + medicineName + ", price=" + price + ", quantity=" + quantity
				+ ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", contactMethod=" + contactMethod + ", additionalComments=" + additionalComments + "]";
	}


	


	

	
	  
	  
}
