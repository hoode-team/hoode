package vip.hoode.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.SQLRestriction;
import vip.hoode.jpa.entity.support.AbstractWebsiteEntity;
import vip.hoode.jpa.repository.support.Queries;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "article")
@SQLRestriction(Queries.CHECK_VALID_SQL)
public class ArticleEntity extends AbstractWebsiteEntity {


    @Column(length = Integer.MAX_VALUE)
    private String content;

    @Column(length = 300)
    private String contentText;

    @Column
    private Date releaseTime;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "article_tag_relation",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<TagEntity> tags;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "article_category_relation",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<CategoryEntity> categories;

}
