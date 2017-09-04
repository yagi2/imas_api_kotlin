package com.yagi2.imas.config

import com.google.common.base.Predicate
import com.google.common.base.Predicates
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class Swagger2Config {

    @Bean
    fun swaggerSpringMvcPlugin(): Docket =
            Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .paths(paths)
                    .build()
                    .apiInfo(apiInfo)

    val paths: Predicate<String> =
            Predicates.or(
                    Predicates.containsPattern("/character/*")
            )

    val apiInfo: ApiInfo =
            ApiInfo(
                    "THE IDOLM@STER API",
                    "THE IDOLM@STER Information API meets Spring Boot + Kotlin",
                    "0.0.1",
                    "",
                    Contact(
                            "yagi2",
                            "https://yagi2.com",
                            "mail@yagi2.com"
                    ),
                    "",
                    "",
                    listOf()
            )
}