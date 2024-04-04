package sit.int204.classicmodelsprac.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsprac.dtos.PageDTO;
import sit.int204.classicmodelsprac.dtos.VerySimpleProductDTO;
import sit.int204.classicmodelsprac.entities.Product;
import sit.int204.classicmodelsprac.repositories.ProductRepository;
import sit.int204.classicmodelsprac.services.ListMapper;
import sit.int204.classicmodelsprac.services.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService service;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ListMapper listMapper;

    @GetMapping("")
    public ResponseEntity<Object> findAllProducts
            (@RequestParam(defaultValue = "0")Double lower,
             @RequestParam(defaultValue = "0")Double upper,
             @RequestParam(defaultValue = "")String productName,
             @RequestParam(defaultValue = "")String[] sortBy,
             @RequestParam(defaultValue = "ASC")String[] direction,
             @RequestParam(defaultValue = "0") int pageNo,
             @RequestParam(defaultValue = "0") int pageSize)
            {

               // return ResponseEntity.ok(service.getProducts( productName , lower , upper , sortBy , direction));

                Page<Product> productPage = service.getProducts(productName , lower , upper ,
                        sortBy , direction, pageNo , pageSize);
                PageDTO<VerySimpleProductDTO>pageDTO = listMapper.toPageDTO(productPage , VerySimpleProductDTO.class , modelMapper);
                return  ResponseEntity.ok(pageDTO);
    }

    @GetMapping("/product-line/{id}")
    public ResponseEntity<Object> getProductsByCategory(@PathVariable String id){
        List<Product> productList = service.getProductsByCategory(id);
        List<VerySimpleProductDTO> vsp = productList.stream().map(p -> modelMapper.
                map(p , VerySimpleProductDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok(vsp);
    }

}
