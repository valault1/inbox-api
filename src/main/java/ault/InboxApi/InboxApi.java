package ault.InboxApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.builders.PathSelectors;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "ault.InboxApi.Entities", "ault.InboxApi.controllers" })
public class InboxApi {

  public static void main(String[] args) {

    SpringApplication.run(InboxApi.class, args);
  }

  // enables Swagger
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any()).build();
  }

  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        //registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:8081");
      }
    };
  }

}
