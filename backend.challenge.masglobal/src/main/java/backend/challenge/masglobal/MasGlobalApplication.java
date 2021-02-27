package backend.challenge.masglobal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(basePackages = { "${project.basePackage}" })
@EnableSwagger2
@SpringBootApplication
public class MasGlobalApplication {

    public static void main(String[] args) {
        SpringApplication.run(MasGlobalApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplateBean() {
        return new RestTemplate();
    }
}
