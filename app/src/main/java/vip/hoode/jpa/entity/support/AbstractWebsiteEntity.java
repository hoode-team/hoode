package vip.hoode.jpa.entity.support;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import vip.hoode.jpa.entity.MetaEntity;
import vip.hoode.jpa.entity.StatisticEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class AbstractWebsiteEntity extends AbstractEntity {

    @Column
    private String name;

    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "meta_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private MetaEntity meta;

    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "statistic_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private StatisticEntity statistic;


}
