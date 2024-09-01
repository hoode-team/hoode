package vip.hoode.object.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * @author mitu2
 */
@Data
public class TagModel implements Serializable {

    private Long id;
    @NotNull
    private String name;

}
