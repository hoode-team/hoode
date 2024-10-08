package vip.hoode.web.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vip.hoode.object.model.ArticleModel;
import vip.hoode.object.view.ArticleView;
import vip.hoode.object.view.BooleanView;

/**
 * @author mitu2
 */
public interface ArticleService {

    Page<ArticleView> getPageable(ArticleModel model, Pageable pageable);

    ArticleView getById(long id);

    BooleanView invalidById(Long id);

    BooleanView save(ArticleModel model);


}
