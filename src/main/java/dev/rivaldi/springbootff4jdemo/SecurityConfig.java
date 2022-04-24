package dev.rivaldi.springbootff4jdemo;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/favicon.ico");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/ff4j-web-console/**").permitAll()
            .and().csrf(csrf -> csrf.ignoringAntMatchers("/ff4j-web-console/**"))
            .authorizeRequests()
            .antMatchers("/api/**").authenticated()
            .and().formLogin().disable()
            .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserDetails customer = User.builder()
            .authorities("customer")
            .username("customer")
            .password("{noop}customer")
            .build();
        UserDetails seller = User.builder()
            .authorities("seller")
            .username("seller")
            .password("{noop}seller")
            .build();
        auth.inMemoryAuthentication()
            .withUser(customer)
            .withUser(seller);
    }
}
