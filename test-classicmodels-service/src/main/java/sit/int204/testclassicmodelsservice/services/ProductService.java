package sit.int204.testclassicmodelsservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int204.testclassicmodelsservice.entities.Customer;
import sit.int204.testclassicmodelsservice.entities.Product;
import sit.int204.testclassicmodelsservice.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }
    public List<Product> findAllProducts(Double lower, Double upper, String productName) {
        if (upper < lower) {
            double tmp = upper;
            upper = lower;
            lower = tmp;
        }
        if (upper <= 0 && lower <= 0) {
            return productRepository.findByProductNameContains(productName);
        } else {
            return productRepository.findByPriceBetweenAndProductNameContains(lower, upper, productName);
            //return  productRepository.findByPriceAndProductName(lower, upper, '%'+ productName + '%');
        }
    }

    public List<Product> findAllProducts(Double lower, Double upper, String productName, String[] sortBy, String[] direction) {
        if (upper < lower) {
            double tmp = upper;
            upper = lower;
            lower = tmp;
        }
        if (upper <= 0 && lower <= 0) {
            upper = productRepository.findFirstByOrderByPriceDesc().getPrice();
        }
        List<Sort.Order> sortOrders = new ArrayList<>();
        if (sortBy != null && sortBy.length > 0) {
            for (int i = 0; i < sortBy.length; i++){
                sortOrders.add(new Sort.Order((direction[i].equalsIgnoreCase("asc") ?
                        Sort.Direction.ASC : Sort.Direction.DESC), sortBy[i]));
            }
        }
            return productRepository.findByPriceBetweenAndProductNameContains(lower, upper, productName, Sort.by(sortOrders));
            //return productRepository.findByBuyPriceBetweenAndProductNameContains(lower, upper, productName);
            //return  productRepository.findByPriceAndProductName(lower, upper, '%'+ productName + '%');
    }
    public Page<Product> findAllProducts(Double lower, Double upper, String productName, String[] sortBy, String[] direction, int pageNo, int pageSize) {
        if (upper < lower) {
            double tmp = upper;
            upper = lower;
            lower = tmp;
        }
        if (upper <= 0 && lower <= 0) {
            upper = productRepository.findFirstByOrderByPriceDesc().getPrice();
        }
        List<Sort.Order> sortOrders = new ArrayList<>();
        if (sortBy != null && sortBy.length > 0) {
            for (int i = 0; i < sortBy.length; i++){
                sortOrders.add(new Sort.Order((direction[i].equalsIgnoreCase("asc") ?
                        Sort.Direction.ASC : Sort.Direction.DESC), sortBy[i]));
            }
        }
        if (pageSize <= 0){ // ไม่ส่ง pageSize
            pageSize = (int) productRepository.count();
        }
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortOrders));
        return productRepository.findByPriceBetweenAndProductNameContains(lower, upper, productName, pageable);
    }
    public List<Product> findAllProductsByProductLine(String productLine) {
        return productRepository.findByProductLineStartingWith(productLine);
    }
}
