package vip.hoode.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import vip.hoode.entity.support.AbstractEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "statistic")
public class StatisticEntity extends AbstractEntity {

    @Column
    private Integer likeQuantity;

    @Column
    private Integer visitQuantity;


}
