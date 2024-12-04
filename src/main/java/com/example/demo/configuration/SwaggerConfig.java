/*
 * File: SwaggerConfig.java
 *
 * Copyright(c) 2024 PSI Services (UK) Ltd. All Rights Reserved.
 * This software is the proprietary information of PSI Services (UK) Ltd.
 *
 * @created: 19/9/2024
 * @copyright: PSI Services (UK) Ltd
 */

package com.example.demo.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class is used to configure the Swagger API documentation.
 */
@Configuration
@NoArgsConstructor
public class SwaggerConfig {

    private String apiVersion="1.0";

    /**
     * Custom OpenAPI configuration.
     *
     * @return OpenAPI object.
     */
    @Bean
    public OpenAPI alertServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Alert Service API")
                        .version(apiVersion)
                        .description("API documentation for the Alert Service"));
    }
}
