package tn.esprit.studenthousing.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(infoAPI());

    }

    public Info infoAPI() {
        return new Info().title("Student Housing MANAGEMENT")
                .description("Case Study - Student Housing")
                .contact(contactAPI());
    }

    public Contact contactAPI() {
        Contact contact = new Contact().name("Atef Maddouri")
                .email("atef.maddouri@esprit.tn")
                .url("https://www.linkedin.com/in/atef-maddouri/");
        return contact;
    }


    @Bean
    public GroupedOpenApi productPublicApi() {
        return GroupedOpenApi.builder()
                .group("SKI STATION Management API")
                .pathsToMatch("/**/**")
                .pathsToExclude("**")
                .build();
    }


}
