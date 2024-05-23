package sit.int204.classicmodelsservice.controllers;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import sit.int204.classicmodelsservice.dtos.VerySimpleProductDTO;
import sit.int204.classicmodelsservice.entities.Product;
import sit.int204.classicmodelsservice.exceptions.ErrorResponse;
import sit.int204.classicmodelsservice.exceptions.ItemNotFoundException;
import sit.int204.classicmodelsservice.services.ListMapper;
import sit.int204.classicmodelsservice.services.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService service;
    @Autowired
    private ListMapper listMapper;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/queryByExample")
    public ResponseEntity<Object> findByExample(){

        return ResponseEntity.ok(service.getProductByExample());
    }


    @GetMapping("")
    public ResponseEntity<Object> findAllProducts(
            @RequestParam(defaultValue = "0") Double lower,
            @RequestParam(defaultValue = "0") Double upper,
            @RequestParam(defaultValue = "") String partOfProductName,
            @RequestParam(defaultValue = "") String[] sortBy,
            @RequestParam(defaultValue = "ASC") String[] direction,
            @RequestParam(defaultValue = "0") @Min(0) int pageNo,
            @RequestParam(defaultValue = "10") @Min(0) @Max(20) int pageSize)
    {
        Page<Product> productPage = service.getProducts(partOfProductName,lower, upper, sortBy, direction, pageNo, pageSize);
        return ResponseEntity.ok(listMapper.toPageDTO(productPage, VerySimpleProductDTO.class, modelMapper));
        //return ResponseEntity.ok(service.getProducts(partOfProductName,lower, upper, sortBy, direction, pageNo, pageSize));
    }
    @GetMapping("/prooducts-line/{id}")
    public ResponseEntity<Object> getProductByCategoty(@PathVariable String id){
        List<Product> productList = service.getProductsByCategory(id);
        List<VerySimpleProductDTO> vsp = productList.stream().map(p -> modelMapper.
                map(p, VerySimpleProductDTO.class)).collect(Collectors.toList());
        return  ResponseEntity.ok(vsp);
        //return service.getProductsByCategory(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable String id){
        return  ResponseEntity.ok(service.getProductById(id));
    }



}
