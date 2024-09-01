package vip.hoode.object.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author mitu2
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooleanView implements Serializable {

    private boolean bool;

    public static BooleanView ofTrue() {
        return new BooleanView(true);
    }

    public static BooleanView ofFalse() {
        return new BooleanView(false);
    }

}
