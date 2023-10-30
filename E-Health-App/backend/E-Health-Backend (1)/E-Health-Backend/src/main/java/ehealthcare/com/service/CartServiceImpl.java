package ehealthcare.com.service;

import ehealthcare.com.entity.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ehealthcare.com.entity.Cart;
import ehealthcare.com.entity.Login;

import ehealthcare.com.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	CartRepository cartRepository;
	
	@Override
	public String addCartItem(String emailid, Login customer, Medicine medrequest, Integer quantity) {
		System.out.println("adding item for: "+emailid);
		Cart cartItem = new Cart(emailid, customer, medrequest, quantity);
		cartRepository.save(cartItem);
		return "Added";
	}
	
	@Override
	public Cart getCartById(String emailid) {
        return cartRepository.findById(emailid)
                .orElseThrow();
    }
	 @Override
	    public Cart updateCart(String emailid, Cart cartDetails) {
	        Cart cart = getCartById(emailid);

	        // Update medicine properties
	        cart.setMedrequest(cartDetails.getMedrequest());
	        cart.setQuantity(cartDetails.getQuantity());
	      

	        return cartRepository.save(cart);
	    }
	 @Override
	    public void deleteCart(String emailid) {
	        Cart cart = getCartById(emailid);
	        cartRepository.delete(cart);
	    }

	
	}


