package vip.hoode.web.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vip.hoode.jpa.entity.ArticleEntity;
import vip.hoode.jpa.repository.WebMenuJpaRepository;
import vip.hoode.object.view.TreeWebMenuView;
import vip.hoode.util.BeanCopyUtils;
import vip.hoode.util.StreamUtils;
import vip.hoode.web.service.WebMenuService;

import java.util.List;

/**
 * @author mitu2
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class WebMenuServiceImpl implements WebMenuService {

    private final WebMenuJpaRepository webMenuJpaRepository;

    @Override
    public List<TreeWebMenuView> getTreeMenus() {
        return StreamUtils.ofNullable(webMenuJpaRepository.findAllByParentIsNull(Sort.by(Sort.Order.asc("menuOrder"))))
                .map(it -> BeanCopyUtils.deepCopyProperties(it, new TreeWebMenuView()))
                .toList();
    }
}
