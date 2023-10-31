package ehealthcare.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ehealthcare.com.entity.MedicationOrder;

public interface MedicationOrderRepository extends JpaRepository<MedicationOrder, Long> { 

}
