package vip.hoode.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import vip.hoode.entity.support.AbstractEntity;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "category")
public class CategoryEntity extends AbstractEntity {

    @Column
    private String name;
    @Column
    private String alias;
    @Column
    private String path;

    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "parent_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private TagEntity parent;

    @ToString.Exclude
    @OneToMany
    @JoinColumn(name = "id", referencedColumnName = "parent_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private List<TagEntity> children;

}
