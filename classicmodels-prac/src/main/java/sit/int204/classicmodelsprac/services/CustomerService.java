package sit.int204.classicmodelsprac.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;
import sit.int204.classicmodelsprac.entities.Customer;

import sit.int204.classicmodelsprac.repositories.CustomerRepository;


import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;
    public Customer findByID(Integer id) {
        return repository.findById(id).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Customer number '"+ id + "' does not exist !!!!"));
    }
}