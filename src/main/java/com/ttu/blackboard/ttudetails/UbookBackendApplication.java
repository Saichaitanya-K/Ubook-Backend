package com.ttu.blackboard.ttudetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;
@SpringBootApplication
public class UbookBackendApplication extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(UbookBackendApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(UbookBackendApplication.class, args);
    }
}
