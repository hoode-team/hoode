package vip.hoode.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vip.hoode.jwt.JwtTokenKit;

/**
 * @author mitu2
 */
@Configuration
public class JwtTokenConfiguration {

    @Bean
    public JwtTokenKit jwtTokenBuilder(HoodeProperties properties) {
        return new JwtTokenKit(properties);
    }

}
