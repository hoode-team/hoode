package vip.hoode.repository;

import org.springframework.stereotype.Repository;
import vip.hoode.entity.UserEntity;
import vip.hoode.repository.support.CustomJpaRepositoryImplementation;

/**
 * @author mitu2
 */
@Repository
public interface UserRepository extends CustomJpaRepositoryImplementation<UserEntity> {
}
