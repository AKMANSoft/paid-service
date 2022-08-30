package com.example.modulepaidservice.modulepaid.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails user = User
                .withUsername("admin")
                .password("$2a$10$jj9Sww6XPfJdb3ZysKhF7Oemjky9U7pTlBu.0U82S06Lr09Zjth6q")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Override
    public void configure(WebSecurity web){
        web.ignoring().mvcMatchers("/api/public/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/",
                    "/home",
                    "/css/**",
                    "/image/**",
                    "/js/**",
                    "/webjars/**",
                    "/resources/**")
            .permitAll()
            .anyRequest().authenticated()
        .and()
            .formLogin()
            .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/module-paid/search", true)
            .usernameParameter("userName").passwordParameter("password")
            .permitAll()
        .and()
            .logout().permitAll();
    }
}
