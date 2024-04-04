package sit.int204.testclassicmodelsservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import sit.int204.testclassicmodelsservice.models.Count;
import sit.int204.testclassicmodelsservice.entities.Office;
import sit.int204.testclassicmodelsservice.repositories.OfficeRepository;

import java.util.List;

@Service

public class OfficeService {
    @Autowired
    private OfficeRepository officeRepository;

//    public List<Office> getAllOffice(String[] param){
//        if(param == null) {
//            return officeRepository.findAll();
//        } else {
//            return officeRepository.findById(List.of(param));
//        }
//    }
    public List<Office> getAllOffice() {
        return officeRepository.findAll();
    }
    public Count getOfficeCount(){
        return new Count(officeRepository.count());
    }
    public Office getOffice(String officeCode){
        return officeRepository.findById(officeCode).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND,
                        "Office Id " + officeCode + " DOES NOT EXIST !!!"){
                }
        );
    }

    @Transactional
    public  Office createNewOffice(Office office){
        return officeRepository.save(office);
    }
    @Transactional
    public void removeOffice(String officeCode){
        Office office = officeRepository.findById(officeCode).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND,
                        "Office Id " + officeCode + " DOES NOT EXIST !!!"));
        officeRepository.delete(office);
    }
    @Transactional
    public Office updateOffice(String officeCode, Office office) {
        if (office.getOfficeCode() != null && office.getOfficeCode().trim().isEmpty()) {
            if (!office.getOfficeCode().equals(officeCode)) {
                throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                        "Conflict Office code !!! (" + officeCode +
                                " vs " + office.getOfficeCode() + ")");
            }
        }
    Office existingOffice = officeRepository.findById(officeCode).orElseThrow(
            () -> new HttpClientErrorException(HttpStatus.NOT_FOUND,
                    "Office Id " + officeCode + " DOES NOT EXIST !!!"));
        return officeRepository.save(office);
    }
}
