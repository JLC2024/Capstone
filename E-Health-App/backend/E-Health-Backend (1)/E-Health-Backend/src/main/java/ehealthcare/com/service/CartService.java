package ehealthcare.com.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ehealthcare.com.entity.Cart;
import ehealthcare.com.entity.Login;
import ehealthcare.com.entity.Medicine;
import ehealthcare.com.repository.CartRepository;


public interface CartService{

	public String addCartItem(String emailid, Login customer, Medicine medrequest, Integer quantity);
		
	Cart getCartById(String emailid);
    
	Cart updateCart(String emailid, Cart cartDetails);
	
	void deleteCart(String emailid);
}
