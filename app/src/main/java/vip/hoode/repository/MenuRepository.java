package vip.hoode.repository;

import org.springframework.stereotype.Repository;
import vip.hoode.entity.MenuEntity;
import vip.hoode.repository.support.CustomJpaRepositoryImplementation;

/**
 * @author mitu2
 */
@Repository
public interface MenuRepository extends CustomJpaRepositoryImplementation<MenuEntity> {
}
