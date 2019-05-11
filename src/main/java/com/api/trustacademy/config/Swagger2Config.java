package com.api.trustacademy.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class Swagger2Config {

  @Bean
  public Docket apiDocket() {
    return new Docket(DocumentationType.SWAGGER_2)
      .select()
      .apis(RequestHandlerSelectors.basePackage("com.api.trustacademy"))
      .paths(PathSelectors.any())
      .build()
      .apiInfo(getApiInfo());
  }

  private ApiInfo getApiInfo() {
    return new ApiInfo(
      "Trust Academy - API",
      "Sistema centralizado para gerenciamento de documentos acadêmicos com segurança via blockchain, e fácil compartilhamento entre instituições.",
      "1.0",
      "https://trustacademy.link",
      null,
      null,
      null,
      Collections.emptyList()
    );
  }
}
