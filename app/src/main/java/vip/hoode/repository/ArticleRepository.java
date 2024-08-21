package vip.hoode.repository;

import org.springframework.stereotype.Repository;
import vip.hoode.entity.ArticleEntity;
import vip.hoode.repository.support.CustomJpaRepositoryImplementation;

/**
 * @author mitu2
 */
@Repository
public interface ArticleRepository extends CustomJpaRepositoryImplementation<ArticleEntity> {
}
