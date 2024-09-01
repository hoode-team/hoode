package vip.hoode.object.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * @author mitu2
 */
@Data
public class MetaModel implements Serializable {

    private Long id;
    @NotNull
    private String route;
    @NotNull
    private String title;
    private String description;
    private String author;
    private String keywords;
}
