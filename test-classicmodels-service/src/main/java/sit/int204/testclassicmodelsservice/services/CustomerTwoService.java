package sit.int204.testclassicmodelsservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int204.testclassicmodelsservice.entities.CustomerTwo;
import sit.int204.testclassicmodelsservice.repositories.CustomerTwoRepository;

import java.util.List;

@Service
public class CustomerTwoService {
    @Autowired
    private CustomerTwoRepository customerTwoRepository;
    public List<CustomerTwo> insertCustomer(List<CustomerTwo> customerTwos){
        return customerTwoRepository.saveAll(customerTwos);
    }
    public List<CustomerTwo> findAllCustomerTwos(){
        return findAllCustomerTwos(null);
    }
    public List<CustomerTwo> findAllCustomerTwos(String name){
        if (name == null || name.isEmpty() || name.isBlank()){
            return customerTwoRepository.findAll();
        } else {
            return customerTwoRepository.findByFirstnameContains(name);
        }
    }
}
