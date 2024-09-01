package vip.hoode.object.view;

import lombok.Data;
import lombok.EqualsAndHashCode;
import vip.hoode.jpa.entity.WebMenuEntity;
import vip.hoode.object.AbstractDeepObjectConverter;

import java.io.Serializable;
import java.util.List;

/**
 * @author mitu2
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TreeWebMenuView extends AbstractDeepObjectConverter<WebMenuEntity> implements Serializable {

    private String mKey;
    private Integer mOrder;
    private Integer level;
    private List<WebMenuEntity> children;

}
