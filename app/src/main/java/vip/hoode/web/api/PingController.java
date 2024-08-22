package vip.hoode.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.hoode.HoodeProperties;

/**
 * @author mitu2
 */
@RestController
@RequestMapping(path = "${hoode.api-version}/ping")
public class PingController {

    @Autowired
    private HoodeProperties hoodeProperties;

    @GetMapping
    public String ping() {
        return String.format("Hoode api version %s", hoodeProperties.getApiVersion());
    }

}
