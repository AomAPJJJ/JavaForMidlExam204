package sit.int204.classicmodelsservice.properties;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "file") //POJO อ่าน properties ที่ขึ้นต้นด้วยคำว่า file

public class FileStorageProperties {
    private String uploadDir; //เปลี่ยนชื่อไม่ได้
    private  String fileServiceHostName;
}
