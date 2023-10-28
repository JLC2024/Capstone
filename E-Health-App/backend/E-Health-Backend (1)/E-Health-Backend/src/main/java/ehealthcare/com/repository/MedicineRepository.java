package ehealthcare.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ehealthcare.com.entity.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer> {
	
	    @Query("SELECT m FROM Medicine m WHERE LOWER(m.mname) LIKE %:searchKey% OR LOWER(m.description) LIKE %:searchKey%")
	    public List<Medicine> findByMnameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String searchKey);
	}

