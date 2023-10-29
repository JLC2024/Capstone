package ehealthcare.com.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ehealthcare.com.entity.Cart;
import ehealthcare.com.entity.Login;
import ehealthcare.com.entity.Medicine;
import ehealthcare.com.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;
	
	public String addCartItem(Login customer, Medicine medrequest, Integer quantity) {
		Cart cartItem = new Cart(customer, medrequest, quantity);
		cartRepository.save(cartItem);
		return "Added";
		
	}
}
