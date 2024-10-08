package vip.hoode.object.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author mitu2
 */
@Data
public class ArticleModel implements Serializable {

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
