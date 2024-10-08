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
public class StatisticView extends EntityView implements Serializable {

    private Integer likeQuantity;
    private Integer visitQuantity;

}
