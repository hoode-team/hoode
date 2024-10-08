package vip.hoode;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

/**
 * @author mitu2
 */
@Data
@ConfigurationProperties(prefix = "hoode")
public class HoodeProperties {

    private String apiVersion;
    private Jwt jwt;
    private Admin admin;

    @Data
    public static class Jwt {

        private String header = "Authorization";
        private String headerPrefix = "Bearer";
        private String secret;
        private Duration expirationTime = Duration.ofDays(7);

    }

    @Data
    public static class Admin {

        public static final String DEFAULT_ADMIN_BASE_PATH = "/admin";

        private String basePath = DEFAULT_ADMIN_BASE_PATH;


    }
}
