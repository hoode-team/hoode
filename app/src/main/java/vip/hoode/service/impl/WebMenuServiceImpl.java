package vip.hoode.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vip.hoode.jpa.repository.WebMenuJpaRepository;
import vip.hoode.object.view.TreeWebMenuView;
import vip.hoode.service.WebMenuService;
import vip.hoode.util.StreamUtil;

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
        return StreamUtil.ofNullable(webMenuJpaRepository.findAllByParentIsNotNull(Sort.by(Sort.Order.asc("mOrder"))))
                .map(it -> {
                    TreeWebMenuView treeWebMenuView = new TreeWebMenuView();
                    treeWebMenuView.fill(it);
                    return treeWebMenuView;
                })
                .toList();
    }
}
