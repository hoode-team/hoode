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

    private Doc doc;

    @Data
    public static class Jwt {
        private String secret;
        private Duration expirationTime = Duration.ofDays(7);
    }

    @Data
    public static class Doc {
        private String host;
    }

}
