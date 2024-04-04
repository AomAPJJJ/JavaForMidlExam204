package sit.int204.classicmodelsprac.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int204.classicmodelsprac.entities.Customera;
import sit.int204.classicmodelsprac.repositories.CustomeraRepository;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomeraService {
    @Autowired
    CustomeraRepository customeraRepository;
    public List<Customera> insertCustomers(List<Customera> customeras) {
        return customeraRepository.saveAll(customeras);
    }

}
