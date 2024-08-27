package vip.hoode.jpa.repository.support;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.NoRepositoryBean;
import vip.hoode.jpa.entity.support.AbstractEntity;

/**
 * @author mitu2
 */
@NoRepositoryBean
public interface JpaRepositoryExtendImplementation<T extends AbstractEntity> extends JpaRepositoryImplementation<T, Long> {

    @Query(Queries.INVALID_SQL)
    @Modifying
    void invalidById(Long id);

    @Query(Queries.INVALID_ALL_SQL)
    @Modifying
    void invalidAll();

}
