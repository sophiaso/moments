/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for
 * license information.
 */
package com.microsoft.azure.moments.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.csrf.WebSessionServerCsrfTokenRepository;

@Configuration
@EnableWebFluxSecurity
public class WebFluxSecurityConfig {
    @Bean
    public SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) throws Exception {
        return http
                .authorizeExchange()
                .pathMatchers("/dist/**", "/js/**").permitAll()
                .pathMatchers("/", "/login**").permitAll()
                .pathMatchers("/**/admin/**").hasRole("ADMIN")
                .and().logout().logoutUrl("/logout")
                .and().authorizeExchange()
                .anyExchange().authenticated()
                .and()
                .formLogin()
                .and().csrf()
                .csrfTokenRepository(new WebSessionServerCsrfTokenRepository())
                .and()
                .build();
    }

    @Bean
    public ReactiveUserDetailsService reactiveUserDetailsService() {
        UserDetails user = User.withUsername("user").password("password").roles("USER").build();
        UserDetails admin = User.withUsername("admin").password("password").roles("ADMIN").build();
        return new MapReactiveUserDetailsService(user, admin);
    }
}
