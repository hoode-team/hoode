package vip.hoode.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author mitu2
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable);

        http.formLogin(configurer -> configurer.loginPage("/admin/login"));

        http.httpBasic(AbstractHttpConfigurer::disable);

        http.authorizeHttpRequests(configurer -> configurer
                .requestMatchers("/admin/login")
                .permitAll()
                .requestMatchers("/admin/**")
                .authenticated()
        );

        return http.build();
    }


}
