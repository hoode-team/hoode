package vip.hoode.web.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    private final HoodeProperties hoodeProperties;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        String basePath = hoodeProperties.getAdmin().getBasePath();

        http.csrf(AbstractHttpConfigurer::disable);

        http.formLogin(configurer -> configurer.loginPage(basePath + "/login"));

        http.httpBasic(AbstractHttpConfigurer::disable);

        http.authorizeHttpRequests(configurer -> configurer
                .requestMatchers(basePath + "/**")
                .authenticated()
                .requestMatchers(basePath + "/login")
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
