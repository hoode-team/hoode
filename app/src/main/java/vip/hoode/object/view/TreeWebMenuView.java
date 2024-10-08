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
public class TreeWebMenuView extends EntityView implements Serializable {

    private String name;
    private String menuKey;
    private Integer menuOrder;
    private MetaView meta;
    private List<TreeWebMenuView> children;

}
