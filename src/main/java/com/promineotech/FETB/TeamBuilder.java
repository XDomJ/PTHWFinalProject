package com.promineotech.FETB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@SpringBootApplication
@ComponentScan
@EntityScan("com.promineotech.FETB.model")
@EnableJpaRepositories(basePackages = "com.promineotech.FETB.repository")//causing an error
public class TeamBuilder {

   public static void main(String[] args) {
     SpringApplication.run(TeamBuilder.class, args);
   }
}
