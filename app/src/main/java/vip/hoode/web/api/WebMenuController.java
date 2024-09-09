package vip.hoode.web.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.hoode.object.view.TreeWebMenuView;
import vip.hoode.web.service.WebMenuService;

import java.util.List;

/**
 * @author mitu2
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Validated
@RestController
@RequestMapping(path = "${hoode.api-version}/web-menu")
public class WebMenuController {

    private final WebMenuService webMenuService;

    @GetMapping(path = "tree")
    public List<TreeWebMenuView> getTreeMenus() {
        return webMenuService.getTreeMenus();
    }

}
