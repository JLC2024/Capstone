package ehealthcare.com.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Login {

	@Id	
	private String emailid;
	
	private String password;
	private String typeofuser;
	


	
	public Login() {
		
	}
	public Login (String emailid, String password, String typeofuser) {
		super();
		this.emailid=emailid;
		this.password=password;
		this.typeofuser=typeofuser;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTypeofuser() {
		return typeofuser;
	}
	public void setTypeofuser(String typeofuser) {
		this.typeofuser = typeofuser;
	}


    @Override
    public String toString() {
        return "Login [emailid=" + emailid + ", password=" + password + ", typeofuser=" + typeofuser + "]";
    }
	
}
