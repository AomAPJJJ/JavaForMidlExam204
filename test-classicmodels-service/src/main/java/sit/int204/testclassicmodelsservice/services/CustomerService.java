package sit.int204.testclassicmodelsservice.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import sit.int204.testclassicmodelsservice.entities.Customer;
import sit.int204.testclassicmodelsservice.repositories.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public Page<Customer> getAllCustomer(int page, int pageSize){
        return customerRepository.findAll(PageRequest.of(page, pageSize));
    }

    public Customer findByID(Integer id){
        return customerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Customer number '" + id + "' does not exist !!!!"));
    }
    @Transactional
    public Customer createNewCustomer(Customer customer){
        return customerRepository.save(customer);
    }
    @Transactional
    public Customer updateCustomer(Integer id, Customer customer) {
        if (customer.getId() != null && !customer.getId().toString().isEmpty()) {
            if (!customer.getId().equals(id)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Conflict Customer number !!! (" + id + " vs " + customer.getId() + ")");
            }
        }
        Customer existingCustomer = customerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Customer number '" + id + "' does not exist !!!!"));
        return customerRepository.save(customer);
    }
    @Transactional
    public void removeCustomer(Integer id) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Customer number '" + id + "' does not exist !!!!"));
        customerRepository.delete(customer);
    }
}
