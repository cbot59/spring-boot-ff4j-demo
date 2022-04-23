package dev.rivaldi.springbootff4jdemo;

import javax.annotation.PostConstruct;

import org.ff4j.FF4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class Ff4jConfig {

    @Bean
    FF4j ff4j() {
        FF4j ff4j = new FF4j();
        ff4j.audit(true);
        ff4j.autoCreate(true);

        return ff4j;
    }
}
