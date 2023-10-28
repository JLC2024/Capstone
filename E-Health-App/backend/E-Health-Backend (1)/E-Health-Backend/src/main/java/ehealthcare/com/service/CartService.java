package ehealthcare.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;

import ehealthcare.com.entity.Cart;
import ehealthcare.com.entity.Login;
import ehealthcare.com.entity.Medicine;
import ehealthcare.com.repository.CartRepository;
import ehealthcare.com.repository.LoginRepository;
import ehealthcare.com.repository.MedicineRepository;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private MedicineRepository medicineRepository;
	@Autowired
	private LoginRepository loginRepository;
	
	
		
	
//	public Cart addToCart(Integer mid) {
//		Optional<Medicine> medicine = medicineRepository.findById(mid);
	
	public Cart addMedicineToCart(Cart cart) {
        return cartRepository.save(cart);
    }
	
	@EntityGraph(attributePaths="medicine")
	public List<Cart> getCustomerCarts(Login customer) {
	    return cartRepository.findByCustomer(customer);
	}
		
	}


