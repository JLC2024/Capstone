package ehealthcare.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ehealthcare.com.entity.Medicine;
import ehealthcare.com.service.MedicineService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/medicine")
@CrossOrigin
public class MedicineController {

	  @Autowired
	    private MedicineService medicineService;

	    @GetMapping("/findAll")
	    public List<Medicine> findAllMedicine() {
	        return medicineService.findAllMedicine();
	    }
	    
	    @GetMapping("/search")
	    public List<Medicine> getAllMedicine(@RequestParam String searchKey){
	    	return medicineService.getAllMedicine(searchKey);
	    }

	    @PostMapping(value = "/store", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public String storeMedicine(@RequestBody Medicine medicine) {
	        return medicineService.storeMedicine(medicine);
	    }

	    @GetMapping("/{mid}")
	    public ResponseEntity<Medicine> getMedicineById(@PathVariable Integer mid) {
	        Medicine medicine = medicineService.getMedicineById(mid);
	        return ResponseEntity.ok(medicine);
	    }

	    @PutMapping("/{mid}")
	    public ResponseEntity<Medicine> updateMedicine(@PathVariable Integer mid, @RequestBody Medicine medicineDetails) {
	        Medicine updatedMedicine = medicineService.updateMedicine(mid, medicineDetails);
	        return ResponseEntity.ok(updatedMedicine);
	    }

	    @DeleteMapping("/{mid}")
	    public ResponseEntity<Map<String, Boolean>> deleteMedicine(@PathVariable Integer mid) {
	        medicineService.deleteMedicine(mid);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return ResponseEntity.ok(response);
	    }
}