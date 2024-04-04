package sit.int204.testclassicmodelsservice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sit.int204.testclassicmodelsservice.dtos.PageDTO;
import sit.int204.testclassicmodelsservice.dtos.SimpleProductDTO;
import sit.int204.testclassicmodelsservice.entities.Product;
import sit.int204.testclassicmodelsservice.models.ProductPage;
import sit.int204.testclassicmodelsservice.services.ListMapper;
import sit.int204.testclassicmodelsservice.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ListMapper listMapper;

    @GetMapping("")
    public ResponseEntity<Object> findAllProducts(@RequestParam(defaultValue = "0") Double lower,
                                                   @RequestParam(defaultValue = "0") Double upper,
                                                   @RequestParam(defaultValue = "") String productName,
                                                   @RequestParam(defaultValue = "") String[] sortBy,
                                                   @RequestParam(defaultValue = "ASC") String[] sortDirection,
                                                   @RequestParam(defaultValue = "0") int pageNo,
                                                   @RequestParam(defaultValue = "0") int pageSize) {
        if (pageSize == 0) { //ไม่ส่ง pageSize
            return ResponseEntity.ok(productService.findAllProducts());
        } else {
//            Page<Product> page = productService.findAllProducts(lower, upper, productName, sortBy, sortDirection, pageNo, pageSize);
//            ProductPage productPage = new ProductPage();
//                productPage.setProductList(page.getContent());
//                productPage.setPageSize(page.getSize());
//                productPage.setTotalElements( (int) page.getTotalElements());
//                productPage.setTotalPage(page.getTotalPages());
//                productPage.setPageNumber(page.getNumber());
//            return ResponseEntity.ok(productPage);
            Page<Product> page = productService.findAllProducts(lower, upper, productName, sortBy, sortDirection, pageNo, pageSize);
            PageDTO<SimpleProductDTO> productDTOPage = listMapper.toPageDTO(page, SimpleProductDTO.class, modelMapper);
            return ResponseEntity.ok(productDTOPage);
        }
    }
    @GetMapping("/product-line/{id}")
    public List<Product> findAllProductsByProductLine(@PathVariable String id){
        return productService.findAllProductsByProductLine(id);
    }
}
