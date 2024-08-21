package vip.hoode.repository;

import org.springframework.stereotype.Repository;
import vip.hoode.entity.TagEntity;
import vip.hoode.repository.support.CustomJpaRepositoryImplementation;

/**
 * @author mitu2
 */
@Repository
public interface TagRepository extends CustomJpaRepositoryImplementation<TagEntity> {
}
