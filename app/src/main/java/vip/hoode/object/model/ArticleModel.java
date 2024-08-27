package vip.hoode.object.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import vip.hoode.object.AbstractObjectConverter;
import vip.hoode.object.view.ArticleView;

import java.io.Serializable;

/**
 * @author mitu2
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ArticleModel extends AbstractObjectConverter<ArticleModel, ArticleView> implements Serializable {
}
