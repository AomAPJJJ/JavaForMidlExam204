package sit.int204.classicmodelsservice.properties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@ConfigurationProperties(prefix = "file")
@Getter
@Setter

public class FileStorageProperties {
    private String uploadDir;
    private String fileServiceHostName;
}
