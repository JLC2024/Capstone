package ehealthcare.com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ehealthcare.com.dto.AddToCartRequest;
import ehealthcare.com.entity.Cart;
import ehealthcare.com.entity.Login;
import ehealthcare.com.entity.Medicine;
import ehealthcare.com.service.CartService;
import ehealthcare.com.service.LoginService;
import ehealthcare.com.service.MedicineService;

@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartController {

	@Autowired
	CartService cartService;
	@Autowired
	LoginService loginService;
	@Autowired
	MedicineService medicineService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addCartItem(@RequestBody AddToCartRequest addToCartRequest) {
		String emailid = addToCartRequest.getEmailid();
		Integer mid = addToCartRequest.getMid();
		Integer quantity = addToCartRequest.getQuantity();
		
		Login customer = loginService.findByEmailid(emailid).orElse(null);
		Medicine medrequest = medicineService.getMedicineById(mid);
		
		if(customer == null || medrequest == null) {
			return ResponseEntity.badRequest().body("Invalid emailid or medicine ID");
		}
		String result = cartService.addCartItem(emailid,customer, medrequest, quantity);

		if ("Added".equals(result)) {
	        return ResponseEntity.ok("Added to Cart");
	    } else {
	        return ResponseEntity.badRequest().body(result);
	   
	    }
	}
	
	
	@GetMapping("/{emailid}")
    public ResponseEntity<Cart> getCartById(@PathVariable String emailid) {
        Cart cart = cartService.getCartById(emailid);
        return ResponseEntity.ok(cart);
    }

    @PutMapping("/{emailid}")
    public ResponseEntity<Cart> updateCart(@PathVariable String emailid, @RequestBody Cart cartDetails) {
        Cart updatedCart = cartService.updateCart(emailid, cartDetails);
        return ResponseEntity.ok(updatedCart);
    }

    @DeleteMapping("/{emailid}")
    public ResponseEntity<Map<String, Boolean>> deleteCart(@PathVariable String emailid) {
        cartService.deleteCart(emailid);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    
	}


