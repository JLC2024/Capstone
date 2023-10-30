package ehealthcare.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ehealthcare.com.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, String>{

}
