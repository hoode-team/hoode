package vip.hoode.repository;

import org.springframework.stereotype.Repository;
import vip.hoode.entity.StatisticEntity;
import vip.hoode.repository.support.CustomJpaRepositoryImplementation;

/**
 * @author mitu2
 */
@Repository
public interface StatisticRepository extends CustomJpaRepositoryImplementation<StatisticEntity> {
}
