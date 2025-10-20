package com.example.investimentos.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI investimentosOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Investimentos Service API")
                        .description("API REST para cadastro e consulta de clientes de investimentos")
                        .version("1.0.0"));
    }
}
