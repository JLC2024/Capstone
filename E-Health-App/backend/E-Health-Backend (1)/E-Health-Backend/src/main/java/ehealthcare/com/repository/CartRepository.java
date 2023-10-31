package ehealthcare.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ehealthcare.com.entity.Cart;
import ehealthcare.com.entity.Medicine;


public interface CartRepository extends JpaRepository<Cart, String>{
	
	Cart findByEmailidAndMedrequest_Mid(String emailid, Integer mid);

 
}
