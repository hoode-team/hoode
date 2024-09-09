package vip.hoode.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.SQLRestriction;
import vip.hoode.jpa.entity.support.AbstractEntity;
import vip.hoode.jpa.repository.support.Queries;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "category")
@SQLRestriction(Queries.CHECK_VALID_SQL)
public class CategoryEntity extends AbstractEntity {

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String alias;

    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "meta_id")
    private MetaEntity meta;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private CategoryEntity parent;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "parent_id")
    private List<CategoryEntity> children;

}
