package ehealthcare.com.dto;

public class MedicationOrderDTO {
	private String medicineName;
    private String phoneNumber;
    private String address;
    private String contactMethod;
    private String additionalComments;
    
	public MedicationOrderDTO() {
		  
	  }

	
	public MedicationOrderDTO(String medicineName, String phoneNumber, String address, String contactMethod,
			String additionalComments) {
		super();
		this.medicineName = medicineName;
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


	@Override
	public String toString() {
		return "MedicationOrderDTO [medicineName=" + medicineName + ", phoneNumber=" + phoneNumber + ", address=" + address + ", contactMethod="
				+ contactMethod + ", additionalComments=" + additionalComments + "]";
	}

	
	  
	  
}
