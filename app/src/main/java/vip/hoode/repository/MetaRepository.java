package vip.hoode.repository;

import org.springframework.stereotype.Repository;
import vip.hoode.entity.MetaEntity;
import vip.hoode.repository.support.CustomJpaRepositoryImplementation;

/**
 * @author mitu2
 */
@Repository
public interface MetaRepository extends CustomJpaRepositoryImplementation<MetaEntity>  {
}
