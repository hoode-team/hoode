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
@Table(name = "meta")
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
