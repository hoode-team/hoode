package vip.hoode.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import vip.hoode.jpa.entity.support.AbstractEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "config")
public class ConfigEntity extends AbstractEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private String value;

}
