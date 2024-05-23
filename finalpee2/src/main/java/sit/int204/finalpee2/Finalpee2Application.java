package sit.int204.finalpee2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import sit.int204.finalpee2.properties.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({ FileStorageProperties.class })
public class Finalpee2Application {
    public static void main(String[] args) {
        SpringApplication.run(Finalpee2Application.class, args);
    }

}
