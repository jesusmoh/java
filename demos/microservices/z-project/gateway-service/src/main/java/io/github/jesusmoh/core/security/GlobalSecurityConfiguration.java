package io.github.jesusmoh.core.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class GlobalSecurityConfiguration {

        private final KeycloakJwtTokenConverter keycloakJwtTokenConverter;

        public GlobalSecurityConfiguration(TokenConverterProperties properties) {
                JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
                this.keycloakJwtTokenConverter = new KeycloakJwtTokenConverter(
                                jwtGrantedAuthoritiesConverter,
                                properties);
        }

        // @Bean
        // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
        // Exception {
        // http
        // .authorizeHttpRequests()
        // .anyRequest()
        // .authenticated();
        // http
        // .oauth2ResourceServer()
        // .jwt()
        // .jwtAuthenticationConverter(keycloakJwtTokenConverter);
        // http
        // .sessionManagement()
        // .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // return http.build();
        // }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http.csrf(AbstractHttpConfigurer::disable)
                                // .exceptionHandling(exception ->
                                // exception.authenticationEntryPoint(unauthorizedHandler))
                                .sessionManagement(session -> session
                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                .authorizeHttpRequests(auth -> auth.requestMatchers("/actuator/**").permitAll()
                                                .requestMatchers("/ping/**").permitAll());

                http.authorizeHttpRequests().anyRequest().authenticated();

                http.oauth2ResourceServer().jwt().jwtAuthenticationConverter(keycloakJwtTokenConverter);

                return http.build();
        }
}