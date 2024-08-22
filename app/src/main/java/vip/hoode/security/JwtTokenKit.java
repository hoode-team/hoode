package vip.hoode.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import vip.hoode.HoodeProperties;
import vip.hoode.jpa.entity.UserEntity;

import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author mitu2
 */
@Slf4j
public class JwtTokenKit {

    private final HoodeProperties properties;
    private final ObjectMapper objectMapper;

    public JwtTokenKit(HoodeProperties properties, ObjectMapper objectMapper) {
        this.properties = properties;
        this.objectMapper = objectMapper;
    }

    public JwtBuilder getJwtBuilder() {
        return Jwts.builder()
                .signWith(Keys.hmacShaKeyFor(properties.getJwt().getSecret().getBytes(StandardCharsets.UTF_8)))
                .issuedAt(new Date());
    }

    public JwtParserBuilder getJwtParserBuilder() {
        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(properties.getJwt().getSecret().getBytes(StandardCharsets.UTF_8)));
    }

    public String getToken(UserEntity user) {
        return getJwtBuilder()
                .expiration(new Date(System.currentTimeMillis() + properties.getJwt().getExpirationTime().toMillis()))
                .id(String.valueOf(user.getId()))
                .subject(user.getUsername())
                .compact();

    }

    public Claims getClaims(String token) {
        return getJwtParserBuilder()
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean isTokenExpired(Claims claims) {
        final Date expiration = claims.getExpiration();
        return expiration != null && expiration.before(new Date());
    }

}
