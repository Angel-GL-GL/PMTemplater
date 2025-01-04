package com.github.angelglgl.pmtemplater.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.github.angelglgl.pmtemplater.services.models.validations.UsersValidation;

@Configuration
public class ValidationsConfig {
    @Bean
    public UsersValidation usersValidation(){
        return new UsersValidation();
    }
}
