package vip.hoode.web.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vip.hoode.object.ConfirmMessage;
import vip.hoode.object.model.ArticleModel;
import vip.hoode.object.view.ArticleView;
import vip.hoode.service.ArticleService;

/**
 * @author mitu2
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Validated
@RestController
@RequestMapping(path = "${hoode.api-version}/article")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping(path = "{id}")
    public ArticleView getById(@PathVariable("id") Long id) {
        return articleService.getById(id);
    }

    @DeleteMapping(path = "{id}")
    public ConfirmMessage deleteById(@PathVariable("id") Long id) {
        return articleService.invalidById(id);
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ConfirmMessage save(@RequestBody ArticleModel model) {
        return articleService.save(model);
    }


}
