package sit.int204.classicmodelsservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sit.int204.classicmodelsservice.entities.Product;
import sit.int204.classicmodelsservice.exeptions.ItemNotFoundException;
import sit.int204.classicmodelsservice.repositories.ProductRepository;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository repository;

    public Page<Product> getProducts(String partOfProduct, Double lower, Double upper,
                                     String[] sortBy, String[] direction, int pageNo, int pageSize) {
        if (lower <= 0 && upper <= 0) {
            upper = repository.findFirstByOrderByPriceDesc().getPrice();
        }
        if (lower > upper) {
            double tmp = lower;
            lower = upper;
            upper = tmp;
        }
        //Sort.Order sortOrder = null;
        if (sortBy != null && sortBy.length > 0) {
            List<Sort.Order> sortOrderList = new ArrayList<>();
            for (int i = 0; i < sortBy.length; i++){
                sortOrderList.add(new Sort.Order(Sort.Direction.valueOf(direction[i].toUpperCase()), sortBy[i]));
            }
            Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortOrderList));
            return repository.findByPriceBetweenAndProductNameContains(lower, upper, partOfProduct, pageable);
        } else {
            Pageable pageable = PageRequest.of(pageNo, pageSize);
            return repository.findByPriceBetweenAndProductNameContains(lower, upper, partOfProduct, pageable);
        }
    }

    public List<Product> getProducts(String partOfProduct, Double lower, Double upper,
                                     String[] sortBy, String[] direction) {
        if (lower <= 0 && upper <= 0) {
            upper = repository.findFirstByOrderByPriceDesc().getPrice();
        }
        if (lower > upper) {
            double tmp = lower;
            lower = upper;
            upper = tmp;
        }
        Sort.Order sortOrder = null;
        if (sortBy != null && sortBy.length > 0) {
            List<Sort.Order> sortOrderList = new ArrayList<>();
            for (int i = 0; i < sortBy.length; i++){
                sortOrderList.add(new Sort.Order(Sort.Direction.valueOf(direction[i].toUpperCase()), sortBy[i]));
            }
            //sortOrder = new Sort.Order(Sort.Direction.valueOf(direction.toUpperCase()), sortBy);
            return repository.findByPriceBetweenAndProductNameContains(lower, upper, partOfProduct, Sort.by(sortOrderList));
        } else {
            return repository.findByPriceBetweenAndProductNameContains(lower, upper, partOfProduct);
        }
    }

        public List<Product> getProducts(String partOfProduct, Double lower, Double upper){
        return getProducts(partOfProduct, lower, upper, null, null);
    }

    public List<Product> getProductsByCategory(String category){
        //return repository.findByProductLineStartingWith(category);
        return repository.getProductsByCategory(category + "%");
    }
    public Product getProductById(String productCode) {
      return    repository.findById(productCode).orElseThrow(()->
                new ItemNotFoundException("Product code: "+ productCode + " does not exists !!!"));
    }
}
