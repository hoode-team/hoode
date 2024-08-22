package vip.hoode.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLRestriction;
import vip.hoode.jpa.entity.support.AbstractEntity;
import vip.hoode.jpa.repository.support.Queries;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "meta")
@SQLRestriction(Queries.CHECK_VALID_SQL)
public class MetaEntity extends AbstractEntity {

    @Column
    private String route;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String author;

    @Column
    private String keywords;

}
