package vip.hoode.web.api;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.hoode.object.type.JsonViewGroups;
import vip.hoode.object.view.TreeWebMenuView;
import vip.hoode.web.service.WebMenuService;

import java.util.List;

/**
 * @author mitu2
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@JsonView(JsonViewGroups.Default.class)
@Validated
@RestController
@RequestMapping(path = "${hoode.api-version}/menu")
public class WebMenuController {

    private final WebMenuService webMenuService;

    @JsonView(JsonViewGroups.IdentityField.class)
    @GetMapping(path = "tree")
    public List<TreeWebMenuView> getTreeMenus() {
        return webMenuService.getTreeMenus();
    }

}
