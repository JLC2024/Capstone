package ehealthcare.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ehealthcare.com.dto.AddToCartRequest;
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
		String result = cartService.addCartItem(customer, medrequest, quantity);
		return ResponseEntity.ok(result);
	}
	
	
	
//	@GetMapping("customer/{emailid}")
//	public ResponseEntity<?> getCustomerCart(@PathVariable String emailid){
//		
//	}
}
