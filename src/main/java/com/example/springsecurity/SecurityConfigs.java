package com.example.springsecurity;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
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
@EnableMethodSecurity //give security to method level
public class SecurityConfigs {

    //for users that are there
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){

        UserDetails admin = User.withUsername("admin").password(passwordEncoder.encode("pass")).roles("ADMIN").build();
        UserDetails user = User.withUsername("Vinay").password(passwordEncoder.encode("Vinay@12345")).roles("USER").build();

        return new InMemoryUserDetailsManager(admin,user);
    }

    //give authentication to api
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.csrf().disable()
                .authorizeHttpRequests().requestMatchers("/home/welcome").permitAll()
                .and().authorizeHttpRequests().requestMatchers("/api/users/signup","/api/wishlists/","/api/wishlists/", "/api/wishlists//{id}").authenticated()
                .and().formLogin().and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
