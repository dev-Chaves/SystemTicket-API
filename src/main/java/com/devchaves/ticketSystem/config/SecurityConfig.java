package com.devchaves.ticketSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests((authorize) ->                      authorize
                        .requestMatchers("/public/**").permitAll()
                        .requestMatchers("/teste").permitAll()
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults());
//                .oauth2Client(Customizer.withDefaults())
//                .oauth2Login(Customizer.withDefaults());

        return http.build();

    }

    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("1234"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
