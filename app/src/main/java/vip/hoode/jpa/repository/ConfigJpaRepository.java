package vip.hoode.jpa.repository;

import org.springframework.stereotype.Repository;
import vip.hoode.jpa.entity.ConfigEntity;
import vip.hoode.jpa.repository.support.JpaRepositoryExtendImplementation;

/**
 * @author mitu2
 */
@Repository
public interface ConfigJpaRepository extends JpaRepositoryExtendImplementation<ConfigEntity> {

    boolean existsByName(String name);

}
