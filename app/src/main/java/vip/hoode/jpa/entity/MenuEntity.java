package vip.hoode.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLRestriction;
import vip.hoode.jpa.entity.support.AbstractWebsiteEntity;
import vip.hoode.jpa.repository.support.Queries;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "menu")
@SQLRestriction(Queries.CHECK_VALID_SQL)
public class MenuEntity extends AbstractWebsiteEntity {

    @Column(unique = true, nullable = false)
    private String mKey;

    @OrderColumn(nullable = false)
    private Integer mOrder;

}
