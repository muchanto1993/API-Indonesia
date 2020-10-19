package com.tnc.config;

import java.util.Collections;

import com.google.common.base.Predicates;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).paths(Predicates.not(PathSelectors.regex("/error/*")))
                .paths(Predicates.not(PathSelectors.regex("/actuator"))).build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("Muhammad Anto Berlianto", "Tech Neural Cyber",
                "m.antoberlianto1993@gmail.com");

        return new ApiInfo("API untuk Informasi Wilayah Indonesia (Provinsi, Kota, Kelurahan, Kecamatan, Kode Pos)",
                "UI Website API menggunakan Swagger Versi 2.7.0 ", "0.0.1",
                "", contact, "", "",
                Collections.emptyList());
    }
}
