package vip.hoode.jpa.repository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import vip.hoode.jpa.entity.WebMenuEntity;
import vip.hoode.jpa.repository.support.JpaRepositoryExtendImplementation;

import java.util.List;

/**
 * @author mitu2
 */
@Repository
public interface WebMenuJpaRepository extends JpaRepositoryExtendImplementation<WebMenuEntity> {

    List<WebMenuEntity> findAllByParentIsNotNull(Sort sort);

}
