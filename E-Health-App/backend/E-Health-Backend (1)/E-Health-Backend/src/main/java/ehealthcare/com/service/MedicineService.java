package ehealthcare.com.service;

import java.util.List;

import ehealthcare.com.entity.Medicine;

public interface MedicineService {

    String storeMedicine(Medicine medicine);

    List<Medicine> findAllMedicine();

    Medicine getMedicineById(Integer id);

    Medicine updateMedicine(Integer id, Medicine medicineDetails);

    void deleteMedicine(Integer id);
    
   
	List<Medicine> getAllMedicine(String searchKey);
}
