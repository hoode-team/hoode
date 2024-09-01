package vip.hoode.object.view;

import lombok.Data;
import lombok.EqualsAndHashCode;
import vip.hoode.jpa.entity.ArticleEntity;
import vip.hoode.object.AbstractDeepObjectConverter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author mitu2
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ArticleView extends AbstractDeepObjectConverter<ArticleEntity> implements Serializable {

    private Long id;

    private String name;
    private MetaView meta;
    private StatisticView statistic;
    private String contentText;
    private String content;
    private List<TagView> tags;
    private List<CategoryView> categories;
    private UserView createdUser;

    private Date createTime;
    private Date updateTime;

}
