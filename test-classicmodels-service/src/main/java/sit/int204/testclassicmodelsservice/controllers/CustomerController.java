package sit.int204.testclassicmodelsservice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sit.int204.testclassicmodelsservice.dtos.PageDTO;
import sit.int204.testclassicmodelsservice.dtos.SimpleCustomerDTO;
import sit.int204.testclassicmodelsservice.entities.Customer;
import sit.int204.testclassicmodelsservice.entities.Order;
import sit.int204.testclassicmodelsservice.services.CustomerService;
import sit.int204.testclassicmodelsservice.services.ListMapper;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ListMapper listMapper;

    // DTO
    @GetMapping("")
    public ResponseEntity<Object> getAllCustomer(@RequestParam(defaultValue = "false") boolean pageable,
                                                 @RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "10") int pageSize){
        if (pageable){
            Page<Customer> customerPage = customerService.getAllCustomer(page, pageSize);
            return ResponseEntity.ok
                    (listMapper.toPageDTO(customerPage, SimpleCustomerDTO.class));
        } else {
            return ResponseEntity.ok
                    (listMapper.mapList(customerService.getAllCustomer(), SimpleCustomerDTO.class));
        }
    }

    // DTO
    @GetMapping("/{id}")
    public ResponseEntity<Object> getCustomerId(@PathVariable Integer id){
        Customer customer = customerService.findByID(id);
        SimpleCustomerDTO simpleCustomerDTO = modelMapper.map(customer, SimpleCustomerDTO.class);
        return ResponseEntity.ok(simpleCustomerDTO);
    }
    @GetMapping("/{id}/orders")
    public List<Order> getCustomerOrder(@PathVariable Integer id){
        return customerService.findByID(id).getOrderList();
    }
    @PostMapping("")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.createNewCustomer(customer);
    }
    @PutMapping("/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Integer customerNumber){
        return customerService.updateCustomer(customerNumber, customer);
    }
    @DeleteMapping("/{id}")
    public void removeCustomer(@PathVariable Integer customerNumber){
        customerService.removeCustomer(customerNumber);
    }
}