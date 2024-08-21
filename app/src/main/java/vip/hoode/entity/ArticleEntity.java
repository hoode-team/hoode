package vip.hoode.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import vip.hoode.entity.support.AbstractPageEntity;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "article")
public class ArticleEntity extends AbstractPageEntity {


    @Column
    private String content;
    @Column
    private String contentText;
    @Column
    private Date releaseTime;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "article_tag_relation",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<TagEntity> tags;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "article_category_relation",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<CategoryEntity> categories;

    @CreatedBy
    @ManyToOne
    private UserEntity createdBy;

}
