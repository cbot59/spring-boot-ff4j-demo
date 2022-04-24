package dev.rivaldi.springbootff4jdemo;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SpringDataSourceProperties.class)
class ApplicationConfiguration {
}
