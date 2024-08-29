package vip.hoode.object.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import vip.hoode.jpa.entity.ArticleEntity;
import vip.hoode.object.AbstractObjectConverter;

import java.io.Serializable;

/**
 * @author mitu2
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ArticleModel extends AbstractObjectConverter<ArticleEntity> implements Serializable {
}
