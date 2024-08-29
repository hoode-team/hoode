package vip.hoode.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.hoode.jpa.entity.ArticleEntity;
import vip.hoode.jpa.repository.ArticleJpaRepository;
import vip.hoode.object.ConfirmMessage;
import vip.hoode.object.model.ArticleModel;
import vip.hoode.object.view.ArticleView;
import vip.hoode.service.ArticleService;
import vip.hoode.util.ServiceUtil;

import java.util.Optional;

/**
 * @author mitu2
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleJpaRepository articleJpaRepository;

    @Override
    public ArticleView getById(long id) {
        Optional<ArticleEntity> optional = articleJpaRepository.findById(id);
        ArticleView view = new ArticleView();
        view.fill(optional.orElseThrow());
        return view;
    }

    @Override
    public ConfirmMessage invalidById(Long id) {
        return articleJpaRepository.findById(id)
                .map(it -> {
                    articleJpaRepository.invalidById(id);
                    return ConfirmMessage.success();
                })
                .orElse(ConfirmMessage.failure());
    }

    @Override
    public ConfirmMessage save(ArticleModel model) {
        if (model == null) {
            return ServiceUtil.DOS("save article model must not be null");
        }
        ArticleEntity target = model.toTarget();
        articleJpaRepository.save(target);
        return ConfirmMessage.success();
    }


}
