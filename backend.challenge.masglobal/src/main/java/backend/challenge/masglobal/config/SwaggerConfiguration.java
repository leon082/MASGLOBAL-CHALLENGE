package backend.challenge.masglobal.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.time.LocalDate;
import java.time.LocalTime;
@Configuration
public class SwaggerConfiguration {

    @Value("${project.basePackage}")
    private String basePackage;


    @Bean
    public Docket swagger() {
        return new Docket(DocumentationType.SWAGGER_2).directModelSubstitute(LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(LocalTime.class, String.class).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage(basePackage)).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(basePackage).description("MasGlobal Challenge").version("0.0.1")
                .build();
    }
}
