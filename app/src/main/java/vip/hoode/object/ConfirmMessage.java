package vip.hoode.object;

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
public class ConfirmMessage implements Serializable {

    private boolean isConfirmed;

    public static ConfirmMessage success() {
        return new ConfirmMessage(true);
    }

    public static ConfirmMessage failure() {
        return new ConfirmMessage(false);
    }

}
