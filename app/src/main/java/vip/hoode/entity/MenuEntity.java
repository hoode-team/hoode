package vip.hoode.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import vip.hoode.entity.support.AbstractPageEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "menu")
public class MenuEntity extends AbstractPageEntity {

    @Column(unique = true, nullable = false)
    private String mKey;

    @OrderColumn(nullable = false)
    private Integer mOrder;

}
