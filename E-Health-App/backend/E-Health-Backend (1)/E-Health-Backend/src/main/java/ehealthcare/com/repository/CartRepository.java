package ehealthcare.com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ehealthcare.com.entity.Cart;
import ehealthcare.com.entity.Login;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

	List<Cart> findByCustomer(Login customer);


}
