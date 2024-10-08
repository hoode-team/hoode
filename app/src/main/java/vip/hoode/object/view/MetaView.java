package vip.hoode.object.view;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import vip.hoode.object.type.JsonViewGroups;

import java.io.Serializable;

/**
 * @author mitu2
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonView(JsonViewGroups.Default.class)
public class MetaView extends EntityView implements Serializable {

    private String route;
    private String title;
    private String description;
    @JsonView(JsonViewGroups.UserField.class)
    private UserView author;
    private String keywords;

}
