package vip.hoode.object.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import vip.hoode.jpa.entity.ArticleEntity;
import vip.hoode.object.AbstractDeepObjectConverter;

import java.io.Serializable;
import java.util.List;

/**
 * @author mitu2
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ArticleModel extends AbstractDeepObjectConverter<ArticleEntity> implements Serializable {

    private Long id;
    private String name;
    @NotNull
    private MetaModel meta;
    @NotNull
    private String contentText;
    @NotNull
    private String content;
    private List<TagModel> tags;
    private List<CategoryModel> categories;

}
