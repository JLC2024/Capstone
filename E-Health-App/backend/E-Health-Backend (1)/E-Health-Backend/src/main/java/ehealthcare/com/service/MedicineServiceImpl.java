package ehealthcare.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ehealthcare.com.entity.Medicine;
import ehealthcare.com.repository.MedicineRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public String storeMedicine(Medicine medicine) {
        medicineRepository.save(medicine);
        return "Medicine details stored successfully";
    }

    @Override
    public List<Medicine> findAllMedicine() {
        return medicineRepository.findAll();
    }
    
    @Override
    public List<Medicine> getAllMedicine(String searchKey) {
        if (searchKey.isEmpty()) {
            return medicineRepository.findAll();
        } else {
            searchKey = searchKey.toLowerCase(); 
            return medicineRepository.findByMnameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(searchKey);
        }
    }


    @Override
    public Medicine getMedicineById(Integer id) {
        return medicineRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public Medicine updateMedicine(Integer id, Medicine medicineDetails) {
        Medicine medicine = getMedicineById(id);

        // Update medicine properties
        medicine.setMname(medicineDetails.getMname());
        medicine.setPrice(medicineDetails.getPrice());
        medicine.setQty(medicineDetails.getQty());
        medicine.setImageurl(medicineDetails.getImageurl());
        medicine.setDescription(medicineDetails.getDescription());

        return medicineRepository.save(medicine);
    }

    @Override
    public void deleteMedicine(Integer id) {
        Medicine medicine = getMedicineById(id);
        medicineRepository.delete(medicine);
    }


	}
