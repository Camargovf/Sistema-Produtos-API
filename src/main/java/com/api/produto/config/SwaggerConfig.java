package com.api.produto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    //Classe Externa Docket

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.api.produto")) //Pacote todas as classes java
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());


    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Produtos API REST - Criado por Valdeir Camargo",
                "API REST de cadastro de produtos",
                "1.0",
                "Termos de Servico",
                new Contact("Valdeir Camargo", "www.valdeircamargo.com", "contato@valdeircamargo.com"),
                "Apache License Version 2.0",
                "https://apache.org/licensen.html", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }

}
