package sit.int204.classicmodelsservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int204.classicmodelsservice.entities.Customera;
import sit.int204.classicmodelsservice.repositories.CustomeraRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomeraService {
    @Autowired
    CustomeraRepository customeraRepository;
    public List<Customera> insertCustomers(List<Customera> customeras) {
        //Long[] ids = customeras.stream().mapToLong(c -> c.getId()); //แก้
        //Long[] ids = customeras.stream().mapToLong(c -> c.getId()).boxed().toArray(Long[]::new);
        //customeraRepository.findAllById(ids);
        return customeraRepository.saveAll(customeras); }
}
