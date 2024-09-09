package vip.hoode.object.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import vip.hoode.jpa.entity.WebMenuEntity;
import vip.hoode.object.AbstractDeepObjectConverter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author mitu2
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TreeWebMenuView extends AbstractDeepObjectConverter<WebMenuEntity> implements Serializable {

    private Long id;
    private String name;
    private String menuKey;
    private Integer menuOrder;
    @JsonIgnoreProperties({"author", "createTime", "updateTime"})
    private MetaView meta;
    private List<TreeWebMenuView> children;

    private Date createTime;
    private Date updateTime;

}
