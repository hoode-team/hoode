package vip.hoode.web.api;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vip.hoode.object.model.ArticleModel;
import vip.hoode.object.type.JsonViewGroups;
import vip.hoode.object.view.ArticleView;
import vip.hoode.object.view.BooleanView;
import vip.hoode.web.service.ArticleService;

/**
 * @author mitu2
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Validated
@RestController
@RequestMapping(path = "${hoode.api-version}/article")
public class ArticleController {

    private final ArticleService articleService;

    @JsonView(JsonViewGroups.EntityCombination.class)
    @GetMapping
    public Page<ArticleView> getPageable(@ModelAttribute @NotNull final ArticleModel model,
                                         @PageableDefault final Pageable pageable) {
        return articleService.getPageable(model, pageable);
    }

    @JsonView(JsonViewGroups.EntityCombination.class)
    @GetMapping(path = "{id}")
    public ArticleView getById(@PathVariable("id") @NotNull Long id) {
        return articleService.getById(id);
    }

    @JsonView(JsonViewGroups.EntityCombination.class)
    @DeleteMapping(path = "{id}")
    @PreAuthorize("isAuthenticated()")
    public BooleanView deleteById(@PathVariable("id") @NotNull Long id) {
        return articleService.invalidById(id);
    }

    @JsonView(JsonViewGroups.EntityCombination.class)
    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public BooleanView save(@RequestBody @NotNull ArticleModel model) {
        return articleService.save(model);
    }


}
