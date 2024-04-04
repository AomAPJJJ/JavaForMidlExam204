package sit.int204.testclassicmodelsservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int204.testclassicmodelsservice.entities.CustomerTwo;
import sit.int204.testclassicmodelsservice.services.CustomerTwoService;

import java.util.List;

@RestController
@RequestMapping("/customeras")
public class CustomerTwoController {
    @Autowired
    CustomerTwoService customerTwoService;

    @PostMapping("")
    public List<CustomerTwo> createCustomers(@RequestBody List<CustomerTwo> customerTwo){
        return customerTwoService.insertCustomer(customerTwo);
    }
    @GetMapping("")
    public List<CustomerTwo> findAllCustomerTwos(@RequestParam(required = false) String filterString){
        return customerTwoService.findAllCustomerTwos(filterString);
    }
}
