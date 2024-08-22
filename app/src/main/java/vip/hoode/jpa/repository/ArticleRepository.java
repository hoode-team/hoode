package vip.hoode.jpa.repository;

import org.springframework.stereotype.Repository;
import vip.hoode.jpa.entity.ArticleEntity;
import vip.hoode.jpa.repository.support.CustomJpaRepositoryImplementation;

/**
 * @author mitu2
 */
@Repository
public interface ArticleRepository extends CustomJpaRepositoryImplementation<ArticleEntity> {
}
