package com.br.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EntityScan(basePackages = { "com.br.crm.model" })
@ComponentScan(basePackages = { "com.*" }) //necessário para realizar o get na rota e redenrizar o html
@EnableJpaRepositories(basePackages = { "com.br.crm.repository" })
@EnableTransactionManagement
@EnableWebMvc
public class CrmApplication implements WebMvcConfigurer {
  public static void main(String[] args) {
    SpringApplication.run(CrmApplication.class, args);
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/login").setViewName("/login");
    registry.setOrder(Ordered.LOWEST_PRECEDENCE);
  }
}
