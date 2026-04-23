package com.codingshuttle.youtube.hospitalManagement.security;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity // Enables Spring Security's web security support
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;
    private final PasswordEncoder passwordEncoder;
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(auth -> auth
//                        // Allow anyone to access APIs starting with /public/
//                        .requestMatchers("/public/**").permitAll()
//                        // Any other request must be authenticated
//                        .anyRequest().authenticated()
//                )
//                // Enable default form login (the UI you see in the browser)
//                .formLogin(Customizer.withDefaults())
//                // Enable basic auth (for Postman testing)
//                .httpBasic(Customizer.withDefaults());
//
//        return http.build();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for testing with Postman
                .sessionManagement(sessionconfig->sessionconfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll() // Allow signup without login
                        .requestMatchers("/public/**").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        // Create a custom user with a specific username and password
//        // Note: {noop} tells Spring this password is not encoded (plain text)
//        UserDetails adminUser = User.withUsername("anuj")
//                .password(passwordEncoder.encode("pass123"))
//                .roles("ADMIN")
//                .build();
//
//        UserDetails doctorUser = User.withUsername("doctor")
//                .password(passwordEncoder.encode("pass123"))
//                .roles("DOCTOR")
//                .build();
//
//        // Use InMemoryUserDetailsManager to manage these users internally
//        return new InMemoryUserDetailsManager(adminUser, doctorUser);
//    }
}