package vip.hoode.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.SQLRestriction;
import vip.hoode.jpa.entity.support.AbstractWebsiteEntity;
import vip.hoode.jpa.repository.support.Queries;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "web_menu")
@SQLRestriction(Queries.CHECK_VALID_SQL)
public class WebMenuEntity extends AbstractWebsiteEntity {

    @Column(length = 50, unique = true, nullable = false)
    private String menuKey;

    @OrderColumn(nullable = false)
    private Integer menuOrder;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private WebMenuEntity parent;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "parent_id")
    private List<WebMenuEntity> children;

}
