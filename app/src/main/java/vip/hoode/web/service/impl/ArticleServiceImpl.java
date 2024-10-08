package vip.hoode.web.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vip.hoode.jpa.entity.ArticleEntity;
import vip.hoode.jpa.repository.ArticleJpaRepository;
import vip.hoode.object.model.ArticleModel;
import vip.hoode.object.view.ArticleView;
import vip.hoode.object.view.BooleanView;
import vip.hoode.util.BeanCopyUtils;
import vip.hoode.web.service.ArticleService;

import java.util.Optional;

/**
 * @author mitu2
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleJpaRepository articleJpaRepository;

    @Override
    public Page<ArticleView> getPageable(ArticleModel model, Pageable pageable) {
        ArticleEntity target = BeanCopyUtils.deepCopyProperties(model, new ArticleEntity());
        Example<ArticleEntity> example = Example.of(target);
        return articleJpaRepository.findAll(example, pageable)
                .map(it -> BeanCopyUtils.deepCopyProperties(it, new ArticleView()));
    }

    @Override
    public ArticleView getById(long id) {
        Optional<ArticleEntity> optional = articleJpaRepository.findById(id);
        return BeanCopyUtils.deepCopyProperties(optional.orElseThrow(), new ArticleView());
    }

    @Override
    public BooleanView invalidById(Long id) {
        return articleJpaRepository.findById(id)
                .map(it -> {
                    articleJpaRepository.invalidById(id);
                    return BooleanView.ofTrue();
                })
                .orElse(BooleanView.ofFalse());
    }

    @Override
    public BooleanView save(ArticleModel model) {
        ArticleEntity target = BeanCopyUtils.deepCopyProperties(model, new ArticleEntity());
        articleJpaRepository.save(target);
        return BooleanView.ofTrue();
    }


}
