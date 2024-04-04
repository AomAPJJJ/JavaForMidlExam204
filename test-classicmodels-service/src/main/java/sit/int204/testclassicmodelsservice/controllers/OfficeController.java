package sit.int204.testclassicmodelsservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int204.testclassicmodelsservice.models.Count;
import sit.int204.testclassicmodelsservice.entities.Employee;
import sit.int204.testclassicmodelsservice.entities.Office;
import sit.int204.testclassicmodelsservice.services.OfficeService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/offices")
public class OfficeController {
    @Autowired
    private OfficeService officeService;

//    @GetMapping("")
//    public List<Office> getAllOffices(@RequestParam(required = false) String[] param){
//        return officeService.getAllOffice(param);
//    }

    @GetMapping("")
    public List<Office> getAllOffices(){
        return officeService.getAllOffice();
    }
    @GetMapping("/count")
    public Count getOfficeCount(){
        return officeService.getOfficeCount();
    }
    @GetMapping("/{officeCode}/employees") // test แล้วมีปัญหา
    public Set<Employee> getOfficeEmployee(@PathVariable String officeCode){
        return officeService.getOffice(officeCode).getEmployee();
    }
    @GetMapping("/{officeCode}")
    public Office getOfficeById(@PathVariable String officeCode){

        return officeService.getOffice(officeCode);
    }
    @PostMapping("")
    public Office addNewOffice(@RequestBody Office office){
        return officeService.createNewOffice(office);
    }
    @PutMapping("/{officeCode}")
    public Office updateOffice(@RequestBody Office office, @PathVariable String officeCode){
        return officeService.updateOffice(officeCode,office);
    }
    @DeleteMapping("/{officeCode}")
    public void removeOffice(@PathVariable String officeCode){
        officeService.removeOffice(officeCode);
    }
}
