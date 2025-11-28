package com.example.cuentas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI baseAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Microservicio API")
                        .version("1.0.0")
                        .description("Documentación auto-generada con Springdoc"));
    }

    @Bean
    public GroupedOpenApi clientesApi() {
        return GroupedOpenApi.builder()
                .group("clientes-personas")
                .pathsToMatch("/api/clientes/**")
                .build();
    }

    @Bean
    public GroupedOpenApi cuentasApi() {
        return GroupedOpenApi.builder()
                .group("cuentas-movimientos")
                .pathsToMatch("/api/cuentas/**", "/api/movimientos/**", "/api/reportes/**")
                .build();
    }
}