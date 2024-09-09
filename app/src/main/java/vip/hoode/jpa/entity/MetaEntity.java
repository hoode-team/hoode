package vip.hoode.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
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
    private String keywords;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_uid")
    private UserEntity author;

}
