package vip.hoode.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import vip.hoode.HoodeProperties;

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
                .requestMatchers("/admin/**")
                .authenticated()
                .requestMatchers("/admin/login")
                .permitAll()
                .anyRequest()
                .permitAll()
        );

        return http.build();
    }


    @Bean
    public JwtTokenKit jwtTokenBuilder(HoodeProperties properties/*, Jackson2ObjectMapperBuilder builder*/) {
        return new JwtTokenKit(properties/*, builder.createXmlMapper(false).build()*/);
    }

}
