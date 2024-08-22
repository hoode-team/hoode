package vip.hoode.security;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import vip.hoode.HoodeApplication;
import vip.hoode.jpa.entity.UserEntity;

/**
 * @author mitu2
 */
@Slf4j
@SpringBootTest(classes = HoodeApplication.class)
class JwtTokenKitTest {

    @Autowired
    private JwtTokenKit jwtTokenKit;

    @Test
    void contextLoads() {
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setUsername("admin");
        user.setPassword("admin");
        String token = jwtTokenKit.getToken(user);
        Assert.hasText(token, "token must not be empty");
        log.info("build admin token: {}", token);
    }


}