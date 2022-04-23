package dev.rivaldi.springbootff4jdemo;

import org.ff4j.FF4j;
import org.ff4j.web.FF4jDispatcherServlet;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(FF4jDispatcherServlet.class)
@AutoConfigureAfter(Ff4jConfig.class)
class Ff4jWebConsole extends SpringBootServletInitializer {

    @Bean
    @ConditionalOnMissingBean
    FF4jDispatcherServlet defineFF4jServlet(FF4j ff4j) {
        FF4jDispatcherServlet servlet = new FF4jDispatcherServlet();
        servlet.setFf4j(ff4j);

        return servlet;
    }

    @Bean
    ServletRegistrationBean<FF4jDispatcherServlet> registerFf4jServlet(FF4jDispatcherServlet servlet) {
        return new ServletRegistrationBean<>(servlet, "/ff4j-web-console/*");
    }
}
