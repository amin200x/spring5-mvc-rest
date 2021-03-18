package guru.springframework.config;

import com.sun.xml.bind.v2.schemagen.xmlschema.Appinfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@EnableSwagger2
@Configuration
public class SwaggerConfig /*extends WebMvcConfigurationSupport*/ {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().pathMapping("/")
                .apiInfo(metaData());
    }

    public ApiInfo metaData() {
        Contact contact = new Contact("Amin.Gh", "Amin.Gh@Gmail.com", "Www.Amin.Gh.Com");

        ApiInfo appinfo = new ApiInfo("Spring Framework Guru",
                "Spring framework's : Beginner to Guru",
                "1.0",
                "Terms of service bla.",
                contact,
                "Apache License Version 2.0",
                "Www.apache.con",
                new ArrayList<>());
        return appinfo;
    }
/*
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //super.addResourceHandlers(registry);

        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources");

        registry.addResourceHandler("/web/jars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }*/
}
