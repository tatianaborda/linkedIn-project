package com.tatianaborda.linkedInproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/api/*", "/api/rest/**").hasRole("API_USER")
                        .requestMatchers("/*", "/actuator/**").authenticated());
        http.formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .permitAll()
                );

        return http.build();

    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1 = User.builder().username("BigBoss")
        .password(passwordEncoder().encode("sssshh"))
                .roles("USER", "API_USER").build();
        UserDetails user2 = User.builder().username("Worker")
                .password(passwordEncoder().encode("youcanpass"))
                .roles("USER").build();
        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
