package com.uttkarsh.springboot.webApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfig {
    // LDAP or Database
    // In memory

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {

        UserDetails userDetails = createNewUser("uttu", "1234");
        UserDetails userDetails2 = createNewUser("isha", "987");

        return new InMemoryUserDetailsManager(userDetails, userDetails2);
    }

    private UserDetails createNewUser(String username, String password) {
        UserDetails userDetails = User.builder().username(username).password(passwordEncoder().encode(password))
                .roles("ADMIN").build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests(auth -> auth.anyRequest().authenticated());
        httpSecurity.formLogin(withDefaults());

        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();

        return httpSecurity.build();
    }
}
