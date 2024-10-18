package com.workshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.workshop.filter.JwtAuthenticationFilter;
import com.workshop.service.JwtHelper;

@Configuration
public class SecurityConfig {
	@Autowired
	private JwtHelper jwtHelper;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    return http.cors().and()
	        .csrf().disable()
	        .authorizeHttpRequests(x ->{ x
	        .requestMatchers("user").permitAll()
     	   .anyRequest().authenticated();
	         
	        }).addFilterBefore(new JwtAuthenticationFilter(jwtHelper), UsernamePasswordAuthenticationFilter.class) 
	        .build(); 
	}
    @Bean
     CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        corsConfiguration.addAllowedOrigin("http://localhost:3000");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsFilter(source);
    }
}
