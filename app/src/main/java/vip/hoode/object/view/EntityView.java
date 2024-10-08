package vip.hoode.object.view;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import vip.hoode.object.type.JsonViewGroups;

import java.util.Date;

@Data
public class EntityView implements JsonViewGroups {

    @JsonView(JsonViewGroups.IdentityField.class)
    private Long id;

    @JsonView(JsonViewGroups.CreateTimeField.class)
    private Date createTime;

    @JsonView(JsonViewGroups.UpdateTimeField.class)
    private Date updateTime;

}
