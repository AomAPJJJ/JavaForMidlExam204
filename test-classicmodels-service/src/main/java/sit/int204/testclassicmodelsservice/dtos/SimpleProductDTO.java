package sit.int204.testclassicmodelsservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleProductDTO {
    private String productCode;
    private String productName;
    private Double price;
}
