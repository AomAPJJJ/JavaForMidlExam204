package sit.int204.testclassicmodelsservice.models;

import lombok.Getter;
import lombok.Setter;
import sit.int204.testclassicmodelsservice.entities.Product;

import java.util.List;

@Getter
@Setter
// DTO- Data Transfer Objects
public class ProductPage {
    private List<Product> productList;
    private  int pageNumber;
    private  int pageSize;
    private  int totalElements;
    private  int totalPage;
}
