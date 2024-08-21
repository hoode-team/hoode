package vip.hoode.repository.support;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.NoRepositoryBean;
import vip.hoode.entity.support.AbstractEntity;

/**
 * @author mitu2
 */
@NoRepositoryBean
public interface CustomJpaRepositoryImplementation<T extends AbstractEntity> extends JpaRepositoryImplementation<T, Long> {
}
