package ehealthcare.com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ehealthcare.com.entity.Cart;
import ehealthcare.com.entity.Login;
import ehealthcare.com.entity.Medicine;
import ehealthcare.com.service.CartService;
import ehealthcare.com.service.LoginService;
import ehealthcare.com.service.MedicineService;

@RestController
public class CartController {
	
	@Autowired
	private CartService cartService;
	@Autowired
	private LoginService loginService;
	@Autowired
	private MedicineService medicineService;
	

	@PostMapping("/add")
	public ResponseEntity<Cart> addMedicineToCart(@RequestBody Cart cart) {
	    Medicine medicineMid = cart.getMedicine();
	    Login customer = cart.getCustomer(); // You'll need to retrieve the customer as well.

	   
	    cart.setMedicine(medicineMid);
	    cart.setCustomer(customer);
	    Cart savedCart = cartService.addMedicineToCart(cart);
	    return new ResponseEntity<>(savedCart, HttpStatus.CREATED);
	}
	
	@GetMapping("/customer/{emailid}")
    public ResponseEntity<List<Cart>> getCustomerCarts(@PathVariable String emailid) {
        Login customer = loginService.findByEmailid(emailid).orElse(null); // Handle null if not found.
        if (customer != null) {
            List<Cart> customerCarts = cartService.getCustomerCarts(customer);
            return new ResponseEntity<>(customerCarts, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }  
}
