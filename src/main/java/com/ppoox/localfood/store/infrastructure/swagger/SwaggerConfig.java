package com.ppoox.localfood.store.infrastructure.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;

//@Configuration
public class SwaggerConfig {
    public OpenAPI baseApi() {
        return new OpenAPI().info(new Info().title("Store Service")
                .description("Store Service API"));
    }

//    @Bean
    public GroupedOpenApi allApi() {
        return GroupedOpenApi.builder().group("All")
                .packagesToScan("com.ppoox.localfood.store.adapter.in.presentation").build();
    }

}
