/*
 * package com.nit.order.security;
 * 
 * import org.springframework.beans.factory.annotation.Value; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.http.HttpMethod; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.method.configuration.
 * EnableGlobalMethodSecurity; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity
 * 
 * @EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
 * public class SecurityConfiguration extends WebMvcConfigurerAdapter {
 * 
 * 
 * 
 * @Value("{api.username}") private String password;
 * 
 * @Value("{api.username}") private String username; protected void
 * configure(HttpSecurity http) throws Exception { http.authorizeRequests()
 * .antMatchers(HttpMethod.OPTIONS,"/**") .permitAll().antMatchers("/**")
 * .authenticated().and().csrf() .disable() .httpBasic();
 * 
 * } protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception { auth .inMemoryAuthentication()
 * .withUser("username").password(PasswordEncoder().encode("username")).roles(
 * "ROLE_ADMIN"); }
 * 
 * @Bean public PasswordEncoder PasswordEncoder() { return new
 * BCryptPasswordEncoder();
 * 
 * }
 * 
 * }
 */