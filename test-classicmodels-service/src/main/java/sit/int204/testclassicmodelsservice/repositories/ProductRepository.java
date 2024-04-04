package sit.int204.testclassicmodelsservice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sit.int204.testclassicmodelsservice.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
//    @Query ("SELECT p FROM Product p WHERE p.price >= :lowerPrice and p.price< :upperPrice and p.productName like :name")
//    List<Product> findByPriceAndProductName(Double lowerPrice, Double upperPrice, String name);
    List<Product> findByPriceBetweenAndProductNameContains(Double lower, Double upper, String productName);
    List<Product> findByProductNameContains(String productName);
    List<Product> findByProductLineStartingWith(String productLine);
    Product findFirstByOrderByPriceDesc(); //มาก -> น้อย

    //Get all products filter by price between and product name contains sorting as request specify
    List<Product> findByPriceBetweenAndProductNameContains(Double lower, Double upper, String productName, Sort sort);

    // Get all products filter by price between and product name contains sorting as request specify with pagination
    Page<Product> findByPriceBetweenAndProductNameContains(Double lower, Double upper, String productName, Pageable pageable);
}
