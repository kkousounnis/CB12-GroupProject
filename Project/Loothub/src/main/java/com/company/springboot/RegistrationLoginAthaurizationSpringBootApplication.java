package com.company.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class RegistrationLoginAthaurizationSpringBootApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        return application.sources(RegistrationLoginAthaurizationSpringBootApplication.class);

    }

    public static void main(String[] args) {
        SpringApplication.run(RegistrationLoginAthaurizationSpringBootApplication.class, args);
    }

}
