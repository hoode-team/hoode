package vip.hoode.initialize.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import vip.hoode.initialize.InitializeLoader;
import vip.hoode.jpa.entity.*;
import vip.hoode.jpa.repository.ConfigJpaRepository;
import vip.hoode.jpa.repository.UserJpaRepository;
import vip.hoode.jpa.repository.WebMenuJpaRepository;

import java.util.Arrays;
import java.util.List;

@Order(0)
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MainInitializeLoader implements InitializeLoader {

    private final WebMenuJpaRepository webMenuJpaRepository;
    private final UserJpaRepository userJpaRepository;
    private final ConfigJpaRepository configJpaRepository;

    @Override
    @Transactional
    public void initialize() {
        initializeWebMenu();
        ConfigEntity config = new ConfigEntity();
        config.setName(MainInitializeLoader.class.getName());
        config.setValue("");
        configJpaRepository.save(config);
    }

    @Override
    public boolean hasInitialized() {
        return !configJpaRepository.existsByName(MainInitializeLoader.class.getName());
    }

    private void initializeWebMenu() {
        UserEntity user = new UserEntity();
        user.setUsername("system");
        UserEntity systemUser = userJpaRepository.save(user);

        WebMenuEntity indexWebMenu = createWebMenu(0, "首页", "index", new String[]{"/", "/home"}, systemUser);
        WebMenuEntity archivesWebMenu = createWebMenu(1, "归档", "archives", new String[]{"/archives"}, systemUser);
        WebMenuEntity aboutMeWebMenu = createWebMenu(2, "关于", "about", new String[]{"/about"}, systemUser);
        List<WebMenuEntity> webMenuEntities = Arrays.asList(indexWebMenu, archivesWebMenu, aboutMeWebMenu);
        webMenuJpaRepository.saveAll(webMenuEntities);
    }

    static WebMenuEntity createWebMenu(int order, String name, String key, String[] routes, UserEntity user) {
        WebMenuEntity webMenu = new WebMenuEntity();
        // webMenu.setId(id);
        webMenu.setName(name);
        webMenu.setMenuKey(key);
        webMenu.setMenuOrder(order);
        webMenu.setStatistic(createStatistic());
        webMenu.setMeta(createMeta(String.join(", ", routes), user));
        return webMenu;
    }

    static StatisticEntity createStatistic() {
        StatisticEntity statistic = new StatisticEntity();
        statistic.setLikeQuantity(0);
        statistic.setVisitQuantity(0);
        return statistic;
    }

    static MetaEntity createMeta(String route, UserEntity user) {
        MetaEntity meta = new MetaEntity();
        meta.setRoute(route);
        meta.setAuthor(user);
        return meta;
    }

}
