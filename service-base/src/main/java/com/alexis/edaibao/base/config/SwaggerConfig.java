package com.alexis.edaibao.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author cc-zj
 * @create 2022-04-12 18:17
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @Bean
    public Docket adminApiConfig(){
        return new Docket(DocumentationType.OAS_30)
                .groupName("后台管理系统API")
                .apiInfo(adminApiInfo())
                .select()
                .paths(PathSelectors.regex("/admin/.*"))
                .build();
    }

    private ApiInfo adminApiInfo() {
        return new ApiInfoBuilder()
                .title("E贷宝后台管理系统API文档")
                .description("本文档描述了E贷宝后台管理系统的各个模块的接口调用方式")
                .version("1.0")
                .contact(new Contact("Alexis","https://www.google.com","changzhenjia@aisino.com"))
                .license("Apache 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }

    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.OAS_30)
                .groupName("网站管理系统API")
                .apiInfo(webApiInfo())
                .select()
                .paths(PathSelectors.regex("/api/.*"))
                .build();
    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("E贷宝网站管理系统API文档")
                .description("本文档描述了E贷宝网站管理系统的各个模块的接口调用方式")
                .version("1.0")
                .contact(new Contact("Alexis","https://www.google.com","changzhenjia@aisino.com"))
                .license("Apache 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }
}
