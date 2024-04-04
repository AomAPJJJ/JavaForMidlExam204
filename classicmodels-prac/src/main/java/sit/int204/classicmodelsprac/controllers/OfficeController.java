package sit.int204.classicmodelsprac.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsprac.entities.Office;
import sit.int204.classicmodelsprac.services.OfficeService;

import java.util.List;

@RestController
@RequestMapping("/api/offices")
public class OfficeController {
    @Autowired
    private OfficeService service;

    @GetMapping("")
    public List<Office>getAllOffices(@RequestParam(required = false)String city){
        return  service.getAllOffice(city);
    }

    @GetMapping("/{officeCode}")
    public Office getOfficeById(@PathVariable String officeCode){
        return  service.getOffice(officeCode);
    }

    @PostMapping("")
    public Office addNewOffice(@RequestBody Office office){
        return  service.createNewOffice(office);
    }

    @PutMapping("/{officeCode}")
    public Office updateOffice(@RequestBody Office office , @PathVariable String officeCode){
        return service.updateOffice(officeCode , office);
    }

    @DeleteMapping("/{officeCode}")
    public void removeOffice(@PathVariable String officeCode){
        service.removeOffice(officeCode);

    }



}
