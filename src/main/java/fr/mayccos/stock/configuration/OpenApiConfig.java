package fr.mayccos.stock.configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("Stock API")
                .description("Project performed in JAVA's Bachelor")
                        .version("1.0")
                        .license(new License().name("Mayccos")));

    }

}
