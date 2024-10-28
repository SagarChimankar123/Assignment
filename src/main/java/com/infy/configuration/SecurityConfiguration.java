//package com.infy.configuration;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
// //Security configuration
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration {
//
//	@Bean
//	  public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//	    http.authorizeHttpRequests((requests) -> requests
//	            .requestMatchers("/customer/register").permitAll()
//	            .requestMatchers("/customer/login").authenticated()
//	            .requestMatchers("/transection/add").authenticated()
//				.requestMatchers("/transection/update").authenticated()
//				.requestMatchers("/point/calculate/{id}").authenticated()
//	            .requestMatchers("").authenticated()
//	            .anyRequest()
//	            .authenticated())
//	        .httpBasic();
//
//	    return http.build();
//	    
//	}
//
//}
