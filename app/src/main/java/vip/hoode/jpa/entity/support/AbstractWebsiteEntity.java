package vip.hoode.jpa.entity.support;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import vip.hoode.jpa.entity.MetaEntity;
import vip.hoode.jpa.entity.StatisticEntity;
import vip.hoode.object.type.SwitchType;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class AbstractWebsiteEntity extends AbstractEntity {

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @ColumnDefault("'" + SwitchType.ON_STATE + "'")
    private SwitchType switchType = SwitchType.ON;

    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "meta_id")
    private MetaEntity meta;

    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "statistic_id")
    private StatisticEntity statistic;


}
