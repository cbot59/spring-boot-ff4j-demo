package dev.rivaldi.springbootff4jdemo;

import javax.annotation.PostConstruct;

import org.ff4j.FF4j;
import org.ff4j.security.AuthorizationsManager;
import org.ff4j.security.SpringSecurityAuthorisationManager;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
class Ff4jConfig {

    @Bean
    FF4j ff4j() {
        FF4j ff4j = new FF4j();
        ff4j.autoCreate(true);
        ff4j.setAuthorizationsManager(new SpringSecurityAuthorisationManager());

        return ff4j;
    }

    @EventListener(ApplicationStartedEvent.class)
    FF4j toggleAudit() {
        ff4j().audit(true);

        return ff4j();
    }
}
