package dev.rivaldi.springbootff4jdemo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Configuration;

@Getter
@AllArgsConstructor
@ConstructorBinding
@ConfigurationProperties("spring.datasource")
class SpringDataSourceProperties {

    private final String username;

    @ToString.Exclude
    private final String password;

    private final String url;

}
