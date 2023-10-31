package ehealthcare.com.service;

import ehealthcare.com.entity.Medicine;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import ehealthcare.com.dto.AddToCartRequest;
import ehealthcare.com.entity.Cart;
import ehealthcare.com.entity.Login;
import ehealthcare.com.exceptions.*;

import ehealthcare.com.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	CartRepository cartRepository;
	
	@Transactional
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

	        cart.setMedrequest(cartDetails.getMedrequest());
	        cart.setQuantity(cartDetails.getQuantity());
	      

	        return cartRepository.save(cart);
	    }
	 @Override
	    public void deleteCart(String emailid) {
	        Cart cart = getCartById(emailid);
	        cartRepository.delete(cart);
	    }
	 
	 	@Override
	    @Transactional
	    public Cart updateItemQuantity(String emailid, Integer mid, Integer quantity) {
	 		Cart cart = cartRepository.findByEmailidAndMedrequest_Mid(emailid, mid);
	        System.out.println("Email ID: " + emailid);
		    System.out.println("Medicine ID: " + mid);
		    System.out.println("New Quantity: " + quantity);
		    
	     
	     
	     if (cart == null) {
	         throw new CartNotFoundException("Cart item not found");
	     }
	     
	   
	     cart.setQuantity(quantity);

	        return cartRepository.save(cart);
	    }

	 
	 @Override
	 public void deleteCartItem(String emailid, Integer mid) {
	     Cart cart = cartRepository.findByEmailidAndMedrequest_Mid(emailid, mid);

	     if (cart != null) {
	         cartRepository.delete(cart);
	     } else {
	         throw new CartNotFoundException("Cart item not found with emailid " + emailid + " and mid " + mid);
	     }
	 }


	
	}


