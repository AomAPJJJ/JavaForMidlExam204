package sit.int204.classicmodelsprac.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import sit.int204.classicmodelsprac.services.ListMapper;

@Configuration
public class ApplicationConfig {
    @Bean
    public ModelMapper modelMapper() {
    return new ModelMapper(); }


    @Bean
    public ListMapper listMapper(){
        return ListMapper.getInstance();
    }
}
