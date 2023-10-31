package ehealthcare.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ehealthcare.com.entity.MedicationOrder;
import ehealthcare.com.repository.MedicationOrderRepository;

@Service
public class MedicationOrderService {
	
	@Autowired
    private MedicationOrderRepository medicationOrderRepository;

    public MedicationOrder saveMedicationOrder(MedicationOrder medicationOrder) {
        return medicationOrderRepository.save(medicationOrder);
    }
}
