package sit.int204.classicmodelsprac.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sit.int204.classicmodelsprac.entities.Product;
import sit.int204.classicmodelsprac.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getProductsByCategory(String category){
        return  repository.getProductsByCategory(category + " % ");
    }
    public Page<Product> getProducts(String productName, Double lower , Double upper ,
                                     String[] sortBy , String[] direction , int pageNo , int pageSize){
        if (lower <= 0 && upper <= 0){
            upper = repository.findFirstByOrderByPriceDesc().getPrice();
        }

        if(lower > upper){
            double tmp = lower;
            lower = upper;
            upper = tmp;
        }
        // Sort.Order sortOrder = null;
        if(sortBy!=null && sortBy.length > 0) {
            List<Sort.Order> sortOrderList = new ArrayList<>();
            for (int i = 0 ; i < sortBy.length ; i++){
                sortOrderList.add(new Sort.Order(Sort.Direction.valueOf(direction[i].toLowerCase()), sortBy[i]));
            }
            Pageable pageable = PageRequest.of(pageNo , pageSize , Sort.by(sortOrderList));
            return repository.findByPriceBetweenAndProductNameContains(lower, upper, productName , pageable);
        }else{
            Pageable pageable = PageRequest.of(pageNo , pageSize );
            return repository.findByPriceBetweenAndProductNameContains(lower, upper, productName , pageable);
        }
    }
    public List<Product> getProducts(String productName, Double lower , Double upper ,
                                     String[] sortBy , String[] direction ){
        if (lower <= 0 && upper <= 0){
            upper = repository.findFirstByOrderByPriceDesc().getPrice();
        }

        if(lower > upper){
            double tmp = lower;
            lower = upper;
            upper = tmp;
        }
        // Sort.Order sortOrder = null;
        if(sortBy!=null && sortBy.length > 0) {
            List<Sort.Order> sortOrderList = new ArrayList<>();
            for (int i = 0 ; i < sortBy.length ; i++){
                sortOrderList.add(new Sort.Order(Sort.Direction.valueOf(direction[i].toLowerCase()), sortBy[i]));
            }

            return  repository.findByPriceBetweenAndProductNameContains(lower, upper, productName , Sort.by(sortOrderList));
        }else{

            return repository.findByPriceBetweenAndProductNameContains(lower, upper, productName);
        }
    }
    public List<Product> getProducts(String productName , Double lower , Double upper ){

        return  getProducts( productName , lower , upper , null ,null);
    }


}
