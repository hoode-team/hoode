package vip.hoode.object.view;

import lombok.Data;
import lombok.EqualsAndHashCode;
import vip.hoode.jpa.entity.*;
import vip.hoode.object.AbstractObjectConverter;
import vip.hoode.object.model.ArticleModel;

import java.io.Serializable;
import java.util.List;

/**
 * @author mitu2
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ArticleView extends AbstractObjectConverter<ArticleModel> implements Serializable {

    private String name;
    private MetaEntity meta;
    private StatisticEntity statistic;
    private String contentText;
    private String content;
    private List<TagEntity> tags;
    private List<CategoryEntity> categories;
    private UserEntity createdUser;

}
