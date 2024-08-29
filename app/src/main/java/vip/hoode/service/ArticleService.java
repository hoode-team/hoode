package vip.hoode.service;

import vip.hoode.object.ConfirmMessage;
import vip.hoode.object.model.ArticleModel;
import vip.hoode.object.view.ArticleView;

/**
 * @author mitu2
 */
public interface ArticleService  {

    ArticleView getById(long id);

    ConfirmMessage invalidById(Long id);

    ConfirmMessage save(ArticleModel model);

}
