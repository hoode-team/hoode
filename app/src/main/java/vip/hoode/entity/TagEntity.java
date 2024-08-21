package vip.hoode.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import vip.hoode.entity.support.AbstractEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "tag")
public class TagEntity extends AbstractEntity {

    @Column
    private String name;

}
