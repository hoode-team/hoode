package vip.hoode.repository;

import org.springframework.stereotype.Repository;
import vip.hoode.entity.CategoryEntity;
import vip.hoode.repository.support.CustomJpaRepositoryImplementation;

/**
 * @author mitu2
 */
@Repository
public interface CategoryRepository extends CustomJpaRepositoryImplementation<CategoryEntity> {
}
