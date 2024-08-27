package vip.hoode.jpa.repository;

import org.springframework.stereotype.Repository;
import vip.hoode.jpa.entity.MenuEntity;
import vip.hoode.jpa.repository.support.JpaRepositoryExtendImplementation;

/**
 * @author mitu2
 */
@Repository
public interface MenuJpaRepository extends JpaRepositoryExtendImplementation<MenuEntity> {
}
