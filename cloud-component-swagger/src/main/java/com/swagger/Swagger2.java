package com.swagger;

<<<<<<< HEAD
=======

>>>>>>> 48a59997046306a92c5b552d972732232f2990e7
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ChenXc
 * @version V1.0
 * @Date 2017/6/30  9:47
 * @Description TODO(一句话描述类作用)
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
<<<<<<< HEAD
                .apis(RequestHandlerSelectors.basePackage("com.jfsoft.peis.controller"))
=======
                .apis(RequestHandlerSelectors.basePackage("com.jfsoft.*.controller"))
>>>>>>> 48a59997046306a92c5b552d972732232f2990e7
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
                .termsOfServiceUrl("http://blog.didispace.com/")
                .contact("程序猿DD")
                .version("1.0")
                .build();
    }
}
