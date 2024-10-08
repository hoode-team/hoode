package vip.hoode.object.view;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vip.hoode.object.type.JsonViewGroups;

import java.io.Serializable;

/**
 * @author mitu2
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonView(JsonViewGroups.Default.class)
public class BooleanView implements Serializable {

    private boolean bool;

    public static BooleanView ofTrue() {
        return new BooleanView(true);
    }

    public static BooleanView ofFalse() {
        return new BooleanView(false);
    }

}
