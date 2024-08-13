package vip.hoode.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import vip.hoode.configuration.HoodeProperties;

import java.nio.charset.StandardCharsets;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author mitu2
 */
@Slf4j
public class JwtTokenKit {

    private final HoodeProperties properties;

    public JwtTokenKit(HoodeProperties properties) {
        this.properties = properties;
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

    public String getToken() {
        return getJwtBuilder()
                .expiration(new Date(System.currentTimeMillis() + properties.getJwt().getExpirationTime().get(ChronoUnit.MILLIS)))
                .compact();
    }

    public Claims getClaims(String token) {
        Claims body;
        try {
            body = getJwtParserBuilder()
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (JwtException e) {
            log.error(e.getMessage(), e);
            return null;
        }

        return body;
    }

    public String getTokeSubject(String token) {
        return getClaims(token).getSubject();
    }

    public Date getTokeExpiration(String token) {
        return getClaims(token).getExpiration();
    }

    public boolean isTokenExpired(String token) {
        final Date expiration = getTokeExpiration(token);
        return expiration.before(new Date());
    }

}
