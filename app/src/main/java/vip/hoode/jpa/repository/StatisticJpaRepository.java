package vip.hoode.jpa.repository;

import org.springframework.stereotype.Repository;
import vip.hoode.jpa.entity.StatisticEntity;
import vip.hoode.jpa.repository.support.JpaRepositoryExtendImplementation;

/**
 * @author mitu2
 */
@Repository
public interface StatisticJpaRepository extends JpaRepositoryExtendImplementation<StatisticEntity> {
}
