package vip.hoode.object.view;

import lombok.Data;
import lombok.EqualsAndHashCode;
import vip.hoode.object.AbstractObjectConverter;
import vip.hoode.object.model.ArticleModel;

import java.io.Serializable;

/**
 * @author mitu2
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ArticleView extends AbstractObjectConverter<ArticleModel, ArticleView> implements Serializable {



}
