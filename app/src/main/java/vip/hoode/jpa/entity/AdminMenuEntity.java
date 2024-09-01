package vip.hoode.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLRestriction;
import vip.hoode.jpa.entity.support.AbstractEntity;
import vip.hoode.jpa.repository.support.Queries;

/**
 * @author mitu2
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "admin_menu")
@SQLRestriction(Queries.CHECK_VALID_SQL)
public class AdminMenuEntity extends AbstractEntity {

    @Column
    private String name;

    @Column(unique = true, nullable = false)
    private String mKey;

    @OrderColumn(nullable = false)
    private Integer mOrder;

}
