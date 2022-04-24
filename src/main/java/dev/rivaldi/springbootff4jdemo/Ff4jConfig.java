package dev.rivaldi.springbootff4jdemo;

import javax.sql.DataSource;

import lombok.RequiredArgsConstructor;
import org.ff4j.FF4j;
import org.ff4j.core.FeatureStore;
import org.ff4j.security.SpringSecurityAuthorisationManager;
import org.ff4j.store.JdbcFeatureStore;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
@RequiredArgsConstructor
class Ff4jConfig {

    private final SpringDataSourceProperties dataSourceConfig;

    @Bean
    FF4j ff4j() {
        FF4j ff4j = new FF4j();
        ff4j.autoCreate(true);
        ff4j.setAuthorizationsManager(new SpringSecurityAuthorisationManager());

        DataSource mysqlDs = DataSourceBuilder.create()
            .username(dataSourceConfig.getUsername())
            .url(dataSourceConfig.getUrl())
            .build();
        FeatureStore featureStore = new JdbcFeatureStore(mysqlDs);
        ff4j.setFeatureStore(featureStore);

        return ff4j;
    }

    @EventListener(ApplicationStartedEvent.class)
    FF4j toggleAudit() {
        ff4j().audit(true);

        return ff4j();
    }
}
