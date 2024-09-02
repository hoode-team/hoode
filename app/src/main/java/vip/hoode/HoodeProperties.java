package vip.hoode;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;
import java.time.Duration;

/**
 * @author mitu2
 */
@Data
@ConfigurationProperties(prefix = "hoode")
public class HoodeProperties implements Serializable {

    private String apiVersion;
    private Jwt jwt;
    private Admin admin;

    @Data
    public static class Jwt {

        private String secret;
        private Duration expirationTime = Duration.ofDays(7);

    }

    @Data
    public static class Admin {

        public static final String DEFAULT_ADMIN_BASE_PATH = "/admin";

        private String basePath = DEFAULT_ADMIN_BASE_PATH;


    }
}
