package vip.hoode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import vip.hoode.configuration.HoodeProperties;

@SpringBootApplication
@EnableConfigurationProperties(HoodeProperties.class)
public class HoodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HoodeApplication.class, args);
    }

}
