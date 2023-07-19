package miu.edu.Avatarservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RewardConfig {
    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
