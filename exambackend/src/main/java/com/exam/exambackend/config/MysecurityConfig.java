package com.exam.exambackend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.exam.exambackend.Services.implement.UserDetailServiceimple;

@Configuration
public class MysecurityConfig {

    @Autowired
    private JWTAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private UserDetailServiceimple userDetailServiceimple;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(
                        csrf -> csrf.disable())
                .cors(cors -> cors.disable())
                .authorizeHttpRequests(
                        auth -> auth

                                .requestMatchers("/auth/*").permitAll()
                                .requestMatchers("/user/*").permitAll()
                                .requestMatchers("/feedback/*").permitAll()
                                .requestMatchers(HttpMethod.OPTIONS).permitAll()
                                .anyRequest().authenticated())
                                .exceptionHandling(exp->exp.accessDeniedHandler(null))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // Password Encoding
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /*
     * @Bean
     * public AuthenticationProvider authenticationProvider()
     * {
     * DaoAuthenticationProvider authenticationProvider = new
     * DaoAuthenticationProvider();
     * authenticationProvider.setUserDetailsService(userDetailsService);
     * authenticationProvider.setPasswordEncoder(passwordEncoder(userDetailsService)
     * );
     * return authenticationProvider;
     * }
     */

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    protected void configure(AuthenticationManagerBuilder au) throws Exception {
        au.userDetailsService(this.userDetailServiceimple).passwordEncoder(passwordEncoder());
    }

}

// Configuring HttpSecurity
/*
 * @Bean
 * public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
 * Exception {
 * return http.csrf(csrf -> csrf.disable())
 * .authorizeHttpRequests()
 * .requestMatchers("/auth/welcome", "/auth/addNewUser",
 * "/auth/generateToken").permitAll()
 * .and()
 * .authorizeHttpRequests().requestMatchers("/auth/user/**").authenticated()
 * .and()
 * .authorizeHttpRequests().requestMatchers("/auth/admin/**").authenticated()
 * .and()
 * .sessionManagement(management -> management
 * .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
 * .authenticationProvider(authenticationProvider())
 * .addFilterBefore(jwtAuthenticationFilter,
 * UsernamePasswordAuthenticationFilter.class)
 * .build();
 * }
 */