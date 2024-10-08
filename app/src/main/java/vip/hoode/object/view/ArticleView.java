package vip.hoode.object.view;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import vip.hoode.object.type.JsonViewGroups;

import java.io.Serializable;
import java.util.List;

/**
 * @author mitu2
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonView(JsonViewGroups.Default.class)
public class ArticleView extends EntityView implements Serializable {

    private String name;
    private MetaView meta;
    private StatisticView statistic;
    private String contentText;
    private String content;
    private List<TagView> tags;
    private List<CategoryView> categories;


}
