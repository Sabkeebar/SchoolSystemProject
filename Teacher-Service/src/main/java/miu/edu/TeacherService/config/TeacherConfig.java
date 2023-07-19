package miu.edu.TeacherService.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TeacherConfig {
    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
