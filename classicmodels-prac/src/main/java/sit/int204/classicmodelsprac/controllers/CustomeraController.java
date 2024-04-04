package sit.int204.classicmodelsprac.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsprac.entities.Customera;

import sit.int204.classicmodelsprac.services.CustomeraService;

import java.util.List;


    @RestController
    @RequestMapping("/customera")
    public class CustomeraController{

        @Autowired
        CustomeraService service;

        @PostMapping("")
        public List<Customera> createCustomera(@RequestBody List<Customera> customeras){
            return  service.insertCustomers(customeras);
        }
    }

