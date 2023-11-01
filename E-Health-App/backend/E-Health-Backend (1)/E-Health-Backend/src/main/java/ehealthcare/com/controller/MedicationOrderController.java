package ehealthcare.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

import ehealthcare.com.entity.MedicationOrder;
import ehealthcare.com.repository.MedicationOrderRepository;
import ehealthcare.com.service.MedicationOrderService;
import ehealthcare.com.dto.MedicationOrderDTO;

@RestController
@RequestMapping("/orders")
public class MedicationOrderController {
	
	@Autowired
    private MedicationOrderRepository orderRepository;
	
	@Autowired MedicationOrderService medicationOrderService;

	@PostMapping("/submit")
    public ResponseEntity<String> submitMedicationOrder(@RequestBody MedicationOrderDTO medicationOrderDTO) {
        try {
            
            MedicationOrder medicationOrder = mapToMedicationOrder(medicationOrderDTO);

          
            medicationOrderService.saveMedicationOrder(medicationOrder);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error submitting medication order: " + e.getMessage());
        }
    }


    @GetMapping("/list")
    public ResponseEntity<List<MedicationOrder>> listOrders() {
        List<MedicationOrder> orders = orderRepository.findAll();
        return ResponseEntity.ok(orders);
    }
    
    @PatchMapping("/approve/{orderId}")
    public ResponseEntity<String> approveOrder(@PathVariable Long orderId) {
      
        Optional<MedicationOrder> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            MedicationOrder order = optionalOrder.get();
            order.setApproved(true);
            orderRepository.save(order);
            return ResponseEntity.ok("Order approved.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    private MedicationOrder mapToMedicationOrder(MedicationOrderDTO medicationOrderDTO) {
        MedicationOrder medicationOrder = new MedicationOrder();
        medicationOrder.setMedicineName(medicationOrderDTO.getMedicineName());
        medicationOrder.setPrice(medicationOrderDTO.getPrice());
        medicationOrder.setQuantity(medicationOrderDTO.getQuantity());
        medicationOrder.setFullName(medicationOrderDTO.getFullName());
        medicationOrder.setPhoneNumber(medicationOrderDTO.getPhoneNumber());
        medicationOrder.setAddress(medicationOrderDTO.getAddress());
        medicationOrder.setContactMethod(medicationOrderDTO.getContactMethod());
        medicationOrder.setAdditionalComments(medicationOrderDTO.getAdditionalComments());
        medicationOrder.setApproved(false);

        return medicationOrder;
    }

}
